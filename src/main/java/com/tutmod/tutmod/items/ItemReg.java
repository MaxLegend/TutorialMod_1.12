package com.tutmod.tutmod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import com.tutmod.tutmod.basic.BasicFood;
import com.tutmod.tutmod.basic.BasicItem;
import com.tutmod.tutmod.basic.GlassCutter;

public class ItemReg
{
    public static Item tutitem = new BasicItem("tutitem",64);
    public static Item tutfood = new BasicFood(20, 4F, false, "tutfood", Items.BONE);
  
    public static Item tuttool = new GlassCutter("tuttool",ToolMaterial.DIAMOND, 20);

    public static void register()
    {

        setRegister(tutfood);
        setRegister(tutitem);
        setRegister(tuttool);
    }

    public static void registerRender()
    {
        setRender(tutfood);
        setRender(tutitem);
        setRender(tuttool);
    }

    private static void registerItems(Item item)
    {
        ForgeRegistries.ITEMS.register(item);
    }

    private static void registerItemsRender(Item item)
    {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
