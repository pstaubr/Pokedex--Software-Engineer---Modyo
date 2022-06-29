package cl.modyo.desafio.pokedex.vo;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PokeDexResponseVO {
    private List<AbilitiesVO> abilities;
    private Long weight;
    private DamageRelationsVO damage_relations;
    private List<DescriptionsVO> descriptions;
    private String baby_trigger_item;
    private ChainVO chain;
    private Long id;
}