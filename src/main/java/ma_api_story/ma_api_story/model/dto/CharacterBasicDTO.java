package ma_api_story.ma_api_story.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record CharacterBasicDTO(
        @JsonProperty("date")
        OffsetDateTime date,

        @JsonProperty("character_name")
        String characterName,

        @JsonProperty("world_name")
        String worldName,

        @JsonProperty("character_gender")
        String characterGender,

        @JsonProperty("character_class")
        String characterClass,

        @JsonProperty("character_class_level")
        String characterClassLevel,

        @JsonProperty("character_level")
        int characterLevel,

        @JsonProperty("character_exp")
        long characterExp,

        @JsonProperty("character_exp_rate")
        String characterExpRate,

        @JsonProperty("character_guild_name")
        String characterGuildName,

        @JsonProperty("character_image")
        String characterImage,

        @JsonProperty("character_date_create")
        OffsetDateTime characterDateCreate,

        @JsonProperty("access_flag")
        String accessFlag,

        @JsonProperty("liberation_quest_clear_flag")
        String liberationQuestClearFlag
) {

}
