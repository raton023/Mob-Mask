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
			}}
			if(event.getEntity() instanceof Zombie) {
			  if(event.getEntity().getType().equals(EntityType.ZOMBIE)){
			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
			  head.setDurability((short) 2);
			  head.setItemMeta(skullMeta);
		  double d = Math.random();
		  if (d < 0.01){ 
			  event.getDrops().add(head);
		  }}
		  }
		  if(event.getEntity() instanceof Skeleton) {
			  if(event.getEntity().getType().equals(EntityType.SKELETON)){
			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
			  head.setDurability((short) 0); // 0 is Skeleton
			  head.setItemMeta(skullMeta);
			  //SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
			  //head.setDurability((short) 3);
			  //skullMeta.setOwner(event.getEntity().getDisplayName());
			  //head.setItemMeta(skullMeta);
		  double d = Math.random();
		  if (d < 0.01){ 
			  event.getDrops().add(head);
		  }}
		  }
		  if(event.getEntity() instanceof Player) {
			  Player p = (Player)event.getEntity();
			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
			  head.setDurability((short) 3); // 3 is for player head
			  skullMeta.setOwner(p.getPlayer().getDisplayName());
			  head.setItemMeta(skullMeta);
		  double d = Math.random();
		  if (d < 0.05){ //5% of prob
			  event.getDrops().add(head);
		  }
		  }
		  if(event.getEntity() instanceof Creeper) {
			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
			  head.setDurability((short) 4); // 4 is for Creeper head
			  head.setItemMeta(skullMeta);
		  double d = Math.random();
		  if (d < 0.01){// 1% of prob 
			  event.getDrops().add(head);
		  }
		  }
			
		}}
	
	
}
