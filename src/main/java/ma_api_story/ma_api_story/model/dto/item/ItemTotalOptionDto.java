package ma_api_story.ma_api_story.model.dto.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemTotalOptionDto(
        @JsonProperty("str")
        String str,
        @JsonProperty("dex")
        String dex,
        @JsonProperty("int")
        String intStat,
        @JsonProperty("luk")
        String luk,
        @JsonProperty("attack_power")
        String attackPower,
        @JsonProperty("magic_power")
        String magicPower,
        @JsonProperty("boss_damage")
        String bossDamage,
        @JsonProperty("ignore_monster_armor")
        String ignoreMonsterArmor
) {
}
