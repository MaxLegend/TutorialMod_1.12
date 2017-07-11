package com.tutmod.tutmod.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabMain extends CreativeTabs{
	public TabMain(String label){
		super(label);
	}
	@Override
	public ItemStack getTabIconItem() {
	
		return new ItemStack(Items.APPLE);
	}
}
