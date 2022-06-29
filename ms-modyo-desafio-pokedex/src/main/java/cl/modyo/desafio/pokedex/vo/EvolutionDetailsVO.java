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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvolutionDetailsVO {
    private String gender;
    private String held_item;
    //private String item;
    private String known_move;
    private String known_move_type;
    private String location;
    private String min_affection;
    private String min_beauty;
    private String min_happiness;
    private String min_level;
    private String needs_overworld_rain;
    private String party_species;
    private String party_type;
    private String relative_physical_stats;
    private String time_of_day;
    private String trade_species;
    private TriggerVO trigger;
    private Boolean turn_upside_down;
}
