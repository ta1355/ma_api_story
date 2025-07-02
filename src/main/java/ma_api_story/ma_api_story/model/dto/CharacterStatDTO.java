package ma_api_story.ma_api_story.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


// api response(/maplestory/v1/character/stat) 응답용
public record CharacterStatDTO(
        @JsonProperty("final_stat") List<StatEntry> finalStat
) {
    public record StatEntry(
            @JsonProperty("stat_name") String statName,
            @JsonProperty("stat_value") String statValue
    ) {}
}
