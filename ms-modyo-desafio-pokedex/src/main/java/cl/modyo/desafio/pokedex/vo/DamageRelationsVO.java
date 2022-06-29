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
public class DamageRelationsVO {
    private List<DoubleDamageFromVO> double_damage_from;
    private List<DoubleDamageToVO> double_damage_to;
    private List<HalfDamageFromVO> half_damage_from;
    private List<HalfDamageToVO> half_damage_to;
    private List<NoDaMageFromVO> no_damage_from;
    private List<NoDaMageToVO> no_damage_to;
    private List<GameIndicesVO> game_indices;
    private GenerationVO generation;
    private Long id;
    private MoveDamageClassVO move_damage_class;
    private List<MovesVO> moves;
    private String name;
    private List<NamesVO> names;
    private List<PastDamageRelationsVO> past_damage_relations;
    private List<PokemonVO> pokemon;
    private Long slot;
}
