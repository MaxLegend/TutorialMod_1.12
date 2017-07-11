package com.tutmod.tutmod;

import net.minecraftforge.common.MinecraftForge;

import com.tutmod.tutmod.event.BreakGlass;

public class RegListEvent {
	public static void init(){
		MinecraftForge.EVENT_BUS.register(new BreakGlass());
	}
}
