package ma_api_story.ma_api_story.controller;

import lombok.RequiredArgsConstructor;
import ma_api_story.ma_api_story.model.dto.character.CharacterBasicDTO;
import ma_api_story.ma_api_story.model.dto.character.CharacterInfoDTO;
import ma_api_story.ma_api_story.model.dto.character.CharacterOCIDDTO;
import ma_api_story.ma_api_story.model.dto.item.ItemDto;
import ma_api_story.ma_api_story.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maple")
@RequiredArgsConstructor
public class MapleController {

    private final CharacterService characterService;

    // 사용자 이름으로 OCID 조회
    @GetMapping("/ocid")
    public ResponseEntity<CharacterOCIDDTO> getCharacterOCID(@RequestParam String name) {
        CharacterOCIDDTO dto = characterService.getCharacterOCID(name);
        return ResponseEntity.ok(dto);
    }

    // OCID로 사용자 기본정보 조회
    @GetMapping("/basic")
    public ResponseEntity<CharacterBasicDTO> getCharacterBasicInfo(@RequestParam String ocid){
        CharacterBasicDTO dto = characterService.getCharacterBasicInfo(ocid);
        return ResponseEntity.ok(dto);
    }

    // 캐릭터 이름으로 사용자 세부정보 조회
    @GetMapping("/character")
    public ResponseEntity<CharacterInfoDTO> getCharacterInfo(@RequestParam String name) {
        CharacterInfoDTO dto = characterService.getCharacterFullInfo(name);
        return ResponseEntity.ok(dto);
    }

    // 캐릭터 이름으로 사용자 장비 조회
    @GetMapping("item_info")
    public ResponseEntity<List<ItemDto>> getCharacterItemInfo(@RequestParam String name){
        List<ItemDto> items = characterService.getItemInfo(name);
        return ResponseEntity.ok(items);
    }
}


// 내 캐릭터 ocid: 4b94e272fd4219c632dffd641f97a341