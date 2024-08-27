package net.jubs.eclipse_do_caos.sound;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent RADIO_SOUNDS = registerSoundEvent("radio_sounds");
    public static final SoundEvent SAMARA_SOUNDS = registerSoundEvent("samara_sounds");

    public static final SoundEvent DELS_FOUND_ESSENCE = registerSoundEvent("dels_found_essence");
    public static final SoundEvent FROG_USE = registerSoundEvent("frog_use");
    public static final SoundEvent GUST = registerSoundEvent("gust");
    public static final SoundEvent FIREBALL = registerSoundEvent("fireball");
    public static final SoundEvent INVISIBLE = registerSoundEvent("invisible");
    public static final SoundEvent DEFENSE = registerSoundEvent("defense");
    public static final SoundEvent POISON_BOLT = registerSoundEvent("poison_bolt");
    public static final SoundEvent LIGHTNING_STRIKE = registerSoundEvent("lightning_strike");
    public static final SoundEvent BEANS = registerSoundEvent("beans");
    public static final SoundEvent RAGE = registerSoundEvent("rage");
    public static final SoundEvent ARTORIAS_HIT = registerSoundEvent("artorias_hit");
    public static final SoundEvent CLAWS_HIT = registerSoundEvent("claws_hit");
    public static final SoundEvent QUARTERSTAFF_HIT = registerSoundEvent("quarterstaff_hit");
    public static final SoundEvent HELENA_HIT = registerSoundEvent("helena_hit");
    public static final SoundEvent SCARLET_RAMPAGE = registerSoundEvent("scarlet_rampage");
    public static final SoundEvent HILDA_HIT = registerSoundEvent("hilda_hit");
    public static final SoundEvent EPICARP = registerSoundEvent("epicarp");
    public static final SoundEvent DIEGO_HIT = registerSoundEvent("diego_hit");
    public static final SoundEvent ADELANTE = registerSoundEvent("adelante");
    public static final SoundEvent AKIRA_HIT = registerSoundEvent("akira_hit");
    public static final SoundEvent TORMENT = registerSoundEvent("torment");
    public static final SoundEvent ODIN_DAGGER_HIT = registerSoundEvent("odin_dagger_hit");
    public static final SoundEvent ODIN_VISION = registerSoundEvent("odin_vision");
    public static final SoundEvent SAI_HIT = registerSoundEvent("sai_hit");
    public static final SoundEvent MISHAP = registerSoundEvent("mishap");
    public static final SoundEvent FLOW = registerSoundEvent("flow");
    public static final SoundEvent VINE_TRAP = registerSoundEvent("vine_trap");
    public static final SoundEvent POSSESSED_CHAOS = registerSoundEvent("possessed_chaos");
    public static final SoundEvent SOUL_ALTERATION = registerSoundEvent("soul_alteration");
    public static final SoundEvent CANNONBALL_BLAST = registerSoundEvent("cannonball_blast");
    public static final SoundEvent EMPTY_CANNON = registerSoundEvent("empty_cannon");
    public static final SoundEvent EMPTY_BEAN_SACK = registerSoundEvent("empty_bean_sack");
    public static final SoundEvent ZORA_BOW_FIRE = registerSoundEvent("zora_bow_fire");
    public static final SoundEvent SAW_EATER_HIT = registerSoundEvent("saw_eater_hit");
    public static final SoundEvent SAW_EATER_SLASHER = registerSoundEvent("saw_eater_slasher");
    public static final SoundEvent INFUSER_POT = registerSoundEvent("infuser_pot");
    public static final SoundEvent LADON_DRAGON_GLAIVE_HIT = registerSoundEvent("ladon_dragon_glaive_hit");
    public static final SoundEvent LEVITATE = registerSoundEvent("levitate");
    public static final SoundEvent ERAK_BATTLEAXE_HIT = registerSoundEvent("erak_battleaxe_hit");
    public static final SoundEvent TREMOR = registerSoundEvent("tremor");
    public static final SoundEvent CROSSING_SPELL = registerSoundEvent("crossing_spell");
    public static final SoundEvent GAUNTLET_HIT = registerSoundEvent("gauntlet_hit");
    public static final SoundEvent GAUNTLET_POWER = registerSoundEvent("gauntlet_power");
    public static final SoundEvent NORR_FORR_HAMMER_HIT = registerSoundEvent("norr_forr_hammer_hit");
    public static final SoundEvent ACCURSE = registerSoundEvent("accurse");


    public static final SoundEvent ECLIPSE_BEGINS = registerSoundEvent("eclipse_begins");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(EclipseDoCaos.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        EclipseDoCaos.LOGGER.info("Registrando Sons do Mod para " + EclipseDoCaos.MOD_ID);
    }
}
