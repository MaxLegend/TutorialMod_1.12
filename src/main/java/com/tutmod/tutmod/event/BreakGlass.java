package com.tutmod.tutmod.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.tutmod.tutmod.items.ItemReg;

public class BreakGlass {
	@SubscribeEvent
	public void onDrop(BlockEvent.HarvestDropsEvent event)
	{		
		EntityPlayer player = (EntityPlayer)event.getHarvester();
		if(!event.getWorld().isRemote)
		{ 	
			if(player != null){
				ItemStack is = player.getHeldItem(EnumHand.MAIN_HAND);
			if (is != null && is.getItem() == ItemReg.tuttool){
			//	 if(event.getDrops() != null)
					if(event.getState().getBlock().equals(Blocks.GLASS) )
				{
				
					event.getDrops().add(new ItemStack(Item.getItemFromBlock(Blocks.GLASS)));
				}
				if(event.getState().getBlock().equals(Blocks.GLASS_PANE))
				{
					event.getDrops().add(new ItemStack(Item.getItemFromBlock(Blocks.GLASS_PANE)));
					
				}
				if(event.getState().getBlock().equals(Blocks.GLOWSTONE))
				{
					event.getDrops().clear();
					event.getDrops().add(new ItemStack(Item.getItemFromBlock(Blocks.GLOWSTONE)));
				}
			}
			}
		}
	}
}

