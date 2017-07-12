package com.tutmod.tutmod.basic.block;

import java.util.Random;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.tutmod.tutmod.MainClass;

public class BasicBlockFalling extends BlockFalling {

	public BasicBlockFalling(Material materialIn, String name, float hardness,float resistanse, String hravLevel, int level, SoundType soundtype) {
		super(materialIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setSoundType(soundtype);
		this.setHardness(hardness);
		this.setResistance(resistanse);
		this.setHarvestLevel(hravLevel, level);
		this.setCreativeTab(MainClass.tabMain);
	}

	private void checkFallable(World worldIn, BlockPos pos) {
	        if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down()))) && pos.getY() >= 0) {
	            int i = 32;

	            if (!fallInstantly && worldIn.isAreaLoaded(pos.add(-32, -32, -32), pos.add(32, 32, 32))) {
	                if (!worldIn.isRemote) {
	                    EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
	                    this.onStartFalling(entityfallingblock);
	                    worldIn.spawnEntity(entityfallingblock);
	                }
	            }
	            else {
	                IBlockState state = worldIn.getBlockState(pos);
	                worldIn.setBlockToAir(pos);
	                BlockPos blockpos;
	                for (blockpos = pos.down(); (worldIn.isAirBlock(blockpos) || canFallThrough(worldIn.getBlockState(blockpos))) && blockpos.getY() > 0; blockpos = blockpos.down()) {
	                    ;
	                }
	                if (blockpos.getY() > 0) {
	                    worldIn.setBlockState(blockpos.up(), state); //Forge: Fix loss of state information during world gen.
	                }
	            }
	        }
	    }
	 @Override
	 public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
	        if (!worldIn.isRemote) {
	            this.checkFallable(worldIn, pos);
	        }
	    }
}
