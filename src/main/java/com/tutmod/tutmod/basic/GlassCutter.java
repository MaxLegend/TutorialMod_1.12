package com.tutmod.tutmod.basic;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;
import com.tutmod.tutmod.MainClass;

public class GlassCutter extends ItemTool {
	  private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.GLASS,Blocks.GLASS_PANE,Blocks.GLOWSTONE);
	  private static final float[] ATTACK_DAMAGES = new float[] {6.0F, 8.0F, 8.0F, 8.0F, 6.0F};
	  private static final float[] ATTACK_SPEEDS = new float[] { -3.2F, -3.2F, -3.1F, -3.0F, -3.0F};
	    
	  	public GlassCutter(String name, Item.ToolMaterial material, int maxDamage) {
	        super(material, EFFECTIVE_ON);
	        this.maxStackSize = 1;
	        this.setMaxDamage(maxDamage);
	    	this.setRegistryName(name);
		this.setCreativeTab(MainClass.tabMain);
		this.setUnlocalizedName(name);
	        this.damageVsEntity = ATTACK_DAMAGES[material.ordinal()];
	        this.attackSpeed = ATTACK_SPEEDS[material.ordinal()];
	  	}
	    	public GlassCutter(Item.ToolMaterial material, float damage, float speed) {
	        super(material, EFFECTIVE_ON);
	        this.damageVsEntity = damage;
	        this.attackSpeed = speed;
	    	}
	    	public float getStrVsBlock(ItemStack stack, IBlockState state) {
	        Material material = state.getMaterial();
	        return material != Material.GLASS ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	    	}
}
