package com.tutmod.tutmod.basic;

import com.tutmod.tutmod.MainClass;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item {
	public BasicItem(String name,int maxStackSize) {
		this.setRegistryName(name);
		this.setCreativeTab(MainClass.tabMain);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
	}
}
