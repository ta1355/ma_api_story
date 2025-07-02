package ma_api_story.ma_api_story.model.dto.item;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


// api값을 받기 위한 dto
public record CharacterItemResponseDto(
        @JsonProperty("date")
        String date,

        @JsonProperty("character_gender")
        String characterGender,

        @JsonProperty("character_class")
        String characterClass,

        @JsonProperty("preset_no")
        Integer presetNo,

        @JsonProperty("item_equipment")
        List<ItemDto> itemEquipment,

        @JsonProperty("item_equipment_preset_1")
        List<ItemDto> itemEquipmentPreset1,

        @JsonProperty("item_equipment_preset_2")
        List<ItemDto> itemEquipmentPreset2,

        @JsonProperty("item_equipment_preset_3")
        List<ItemDto> itemEquipmentPreset3
) {
}
