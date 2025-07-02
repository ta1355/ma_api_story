package ma_api_story.ma_api_story.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterInfoDTO {
    private String characterName;
    private String worldName;
    private String characterClass;
    private int characterLevel;
    private String characterImage;
    private long characterExp;
    private String characterExpRate;
    private String characterGender;
    private String characterGuildName;

    private double damage;
    private double bossDamage;
    private double finalDamage;
    private double ignoreDefense;
    private int critRate;
    private double critDamage;
    private int str;
    private int dex;
    private int intel;
    private int luk;
    private int hp;
    private int attackPower;
    private int magicPower;
    private int battlePower;
    private int itemDropRate;
    private int buffDuration;
    private int summonDuration;
    private int reuseCooldownSec;
}
