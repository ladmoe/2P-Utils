package moe.lad.fabric.Config;

import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.container.FlowLayout;
import moe.lad.Twoplayer_utils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;


public class ConfigScreenComplex extends BaseUIModelScreen<FlowLayout> {

    public ConfigScreenComplex() {
        super(FlowLayout.class, DataSource.asset(ResourceLocation.parse(Twoplayer_utils.MOD_ID+":my_ui_model")));
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        //TODO add logic

        rootComponent.childById(ButtonComponent.class,"my-button").onPress(button ->{
            Twoplayer_utils.LOGGER.info("button has been clicked! "+ button.id());
        });
        rootComponent.childById(ButtonComponent.class,"my-button2").onPress(button ->{
            Twoplayer_utils.LOGGER.info("button has been clicked! "+ button.id()+" "+Component.translatable("text.twoplayer.sample").getString());
        });
    }
}
