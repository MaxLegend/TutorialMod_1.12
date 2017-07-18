public class EventBlock {
	
	@SubscribeEvent
	public void blockClick(RightClickBlock.RightClickBlock event) {
		
		ItemStack is = event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
		
		if (is != null && (is.getItem() == Items.CARROT)) {
			if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.GRASS) {
				event.getWorld().setBlockState(event.getPos(), Blocks.BEDROCK.getDefaultState());
				event.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Blocks.GRASS));
			}
		}
	}
}
