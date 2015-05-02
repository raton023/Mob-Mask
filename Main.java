package com.craftilandia.friendlymobs;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		}
	@EventHandler
	public void damage(EntityDamageEvent e){	
		if (e.getEntity() instanceof Player){
		Player p = (Player)e.getEntity();
		if (p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getType().equals(Material.SKULL_ITEM)){
				e.setCancelled(true);//Monsters set to make no damage
			}}}}}
