package ma_api_story.ma_api_story.service;

import lombok.RequiredArgsConstructor;
import ma_api_story.ma_api_story.model.dto.CharacterBasicDTO;
import ma_api_story.ma_api_story.model.dto.CharacterInfoDTO;
import ma_api_story.ma_api_story.model.dto.CharacterOCIDDTO;
import ma_api_story.ma_api_story.model.dto.CharacterStatDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterService {

    @Qualifier("nexonWebClient")
    private final WebClient nexonWebClient;


    // 캐릭터 이름으로 ocid 조회
    public CharacterOCIDDTO getCharacterOCID(String characterName){
        return nexonWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/id")
                        .queryParam("character_name" , characterName)
                        .build())
                .retrieve()
                .bodyToMono(CharacterOCIDDTO.class)
                .block();
    }

    // ocid로 캐릭터 기본정보 조회
    public CharacterBasicDTO getCharacterBasicInfo(String ocid){
        return nexonWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/character/basic")
                        .queryParam("ocid", ocid)
                        .build())
                .retrieve()
                .bodyToMono(CharacterBasicDTO.class)
                .block();
    }

    // ocid로 캐릭터 정보 조회
    public CharacterStatDTO getCharacterStatInfo(String ocid){
        return nexonWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/character/stat")
                        .queryParam("ocid", ocid)
                        .build())
                .retrieve()
                .bodyToMono(CharacterStatDTO.class)
                .block();
    }

    // getCharacterBasicInfo,getCharacterStatInfo에서 필요한 정보만 가져온 함수(실질적 사용)
    public CharacterInfoDTO getCharacterFullInfo(String name) {
        CharacterOCIDDTO ocidDto = getCharacterOCID(name);
        String ocid = ocidDto.ocid();

        CharacterBasicDTO basic = getCharacterBasicInfo(ocid);
        CharacterStatDTO stat = getCharacterStatInfo(ocid);

        Map<String, String> statMap = stat.finalStat().stream()
                .collect(Collectors.toMap(CharacterStatDTO.StatEntry::statName, CharacterStatDTO.StatEntry::statValue)); // statName을 키로 statValue을 벨류로 하는 statMap을 만들어서 사용

        return CharacterInfoDTO.builder()
                .characterName(basic.characterName())
                .worldName(basic.worldName())
                .characterClass(basic.characterClass())
                .characterLevel(basic.characterLevel())
                .characterImage(basic.characterImage())
                .characterExp(basic.characterExp())
                .characterExpRate(basic.characterExpRate())
                .characterGender(basic.characterGender())
                .characterGuildName(basic.characterGuildName())

                .damage(parseDouble(statMap.get("데미지")))
                .bossDamage(parseDouble(statMap.get("보스 몬스터 데미지")))
                .finalDamage(parseDouble(statMap.get("최종 데미지")))
                .ignoreDefense(parseDouble(statMap.get("방어율 무시")))
                .critRate(parseInt(statMap.get("크리티컬 확률")))
                .critDamage(parseDouble(statMap.get("크리티컬 데미지")))
                .str(parseInt(statMap.get("STR")))
                .dex(parseInt(statMap.get("DEX")))
                .intel(parseInt(statMap.get("INT")))
                .luk(parseInt(statMap.get("LUK")))
                .hp(parseInt(statMap.get("HP")))
                .attackPower(parseInt(statMap.get("공격력")))
                .magicPower(parseInt(statMap.get("마력")))
                .battlePower(parseInt(statMap.get("전투력")))
                .itemDropRate(parseInt(statMap.get("아이템 드롭률")))
                .buffDuration(parseInt(statMap.get("버프 지속시간")))
                .summonDuration(parseInt(statMap.get("소환수 지속시간 증가")))
                .reuseCooldownSec(parseInt(statMap.get("재사용 대기시간 감소 (초)")))
                .build();
    }

    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return 0;
        }
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }
}
