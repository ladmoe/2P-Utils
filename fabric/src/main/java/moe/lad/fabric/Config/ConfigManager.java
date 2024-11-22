package moe.lad.fabric.Config;

import io.wispforest.owo.config.annotation.*;
import moe.lad.Twoplayer_utils;

import java.util.ArrayList;
import java.util.List;

@Modmenu(modId = Twoplayer_utils.MOD_ID)
@Config(name = "twoplayer-config", wrapperName = "TwoConfig")
public class ConfigManager {
    @RangeConstraint(min = -1000, max = 1000)
    public int myNumber =999;


    public double quality = 1;

    public double size;

    public boolean aBooleanToggle = false;
    public Choices anotherEnumOption = Choices.ANOTHER_CHOICE;
    public Choices anEnumOption = Choices.A_CHOICE;
    public enum Choices {
        A_CHOICE, ANOTHER_CHOICE;
    }

    // we want to only allow lists of length 5
    @PredicateConstraint("predicateFunction")
    @Expanded
    public List<String> someOption = new ArrayList<>(List.of("1", "2", "3", "4", "5"));
    //Once the user enters a value into ^, it calls predicateFunction(someOption) and saves if it returns true.

    // so we declare a predicate method
    public static boolean predicateFunction(List<String> list) {
        // and do the check in here
        // this could be arbitrarily complex code, but
        // we'll keep it simple for this demonstration
        return list.size() == 5; //since this is size() == 5, if it isn't the size of 5, then it will not save.
    }


    @RestartRequired
    public boolean fatalOption = false;

}
