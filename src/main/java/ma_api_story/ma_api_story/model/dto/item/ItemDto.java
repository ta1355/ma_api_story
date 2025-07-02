package ma_api_story.ma_api_story.model.dto.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemDto(
        @JsonProperty("item_equipment_part")
        String itemEquipmentPart,    // 장비 부위

        @JsonProperty("item_name")
        String itemName,             // 아이템 이름

        @JsonProperty("item_icon")
        String itemIcon,             // 아이콘 URL

        @JsonProperty("item_total_option")
        ItemTotalOptionDto itemTotalOption, // 최종 스탯

        @JsonProperty("potential_option_grade")
        String potentialOptionGrade, // 잠재능력 등급

        @JsonProperty("potential_option_1")
        String potentialOption1,     // 잠재능력 옵션 1

        @JsonProperty("potential_option_2")
        String potentialOption2,     // 잠재능력 옵션 2

        @JsonProperty("potential_option_3")
        String potentialOption3,     // 잠재능력 옵션 3

        @JsonProperty("additional_potential_option_grade")
        String additionalPotentialOptionGrade, // 에디셔널 잠재 등급

        @JsonProperty("additional_potential_option_1")
        String additionalPotentialOption1,     // 에디셔널 잠재 1

        @JsonProperty("additional_potential_option_2")
        String additionalPotentialOption2,     // 에디셔널 잠재 2

        @JsonProperty("additional_potential_option_3")
        String additionalPotentialOption3,     // 에디셔널 잠재 3

        @JsonProperty("starforce")
        String starforce,             // 스타포스 수치

        @JsonProperty("item_base_option")
        ItemBaseOptionDto itemBaseOption, // 아이템 기본 옵션(레벨 포함)

        @JsonProperty("soul_name")
        String soulName,              // 소울 이름

        @JsonProperty("soul_option")
        String soulOption             // 소울 옵션
) {
}


