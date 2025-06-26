package ma_api_story.ma_api_story.service;

import lombok.RequiredArgsConstructor;
import ma_api_story.ma_api_story.model.dto.CharacterOCIDDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CharacterService {

    @Qualifier("nexonWebClient")
    private final WebClient nexonWebClient;

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
}
