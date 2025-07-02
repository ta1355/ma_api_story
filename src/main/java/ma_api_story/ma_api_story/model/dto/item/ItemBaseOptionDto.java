package ma_api_story.ma_api_story.model.dto.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemBaseOptionDto(
        @JsonProperty("base_equipment_level")
        Integer baseEquipmentLevel    // 아이템 레벨
) {}
