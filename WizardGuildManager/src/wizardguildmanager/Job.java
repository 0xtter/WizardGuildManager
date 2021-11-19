/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

/**
 *
 * @author ybert
 */
public enum Job {
    WAITER,
    SINGER,
    BARTENDER;

    @Override
    public String toString( 
        Job this) {
       return switch (this) {
            case WAITER ->
                "serveur,euse";
            case SINGER ->
                "chanteur,euse";
            case BARTENDER ->
                "barman,maid";
        };
    }
}
