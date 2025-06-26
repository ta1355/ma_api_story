package ma_api_story.ma_api_story.controller;

import lombok.RequiredArgsConstructor;
import ma_api_story.ma_api_story.model.dto.CharacterOCIDDTO;
import ma_api_story.ma_api_story.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
