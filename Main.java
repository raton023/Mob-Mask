package com.craftilandia.friendlymobs;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin implements Listener {
	ArrayList<Integer> dropeos = new ArrayList<Integer>();
	@Override
	public void onEnable() {Bukkit.getServer().getPluginManager().registerEvents(this, this);}
	@EventHandler
	public void damage(EntityDamageByEntityEvent e){	
		if (e.getEntity() instanceof Player){
		Player p = (Player)e.getEntity();
		if (p.getInventory().getHelmet() != null) {
			//very important null check so it not gives null when nothing is on helmet
			if(p.getInventory().getHelmet().getType().equals(Material.SKULL_ITEM)){
				e.setCancelled(true);}}}}//Monsters set to make no damage
			
	  @EventHandler
	  public void onEntityDeath(EntityDeathEvent event){
		  if(event.getEntity() instanceof Zombie) {
		  			  if(event.getEntity().getType().equals(EntityType.ZOMBIE)){
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 2);
		  			  head.setItemMeta(skullMeta);
		  			  if(dropeos.size() >= 100){
		  				  event.getDrops().add(head);
		  				  dropeos.clear();}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				if(event.getEntity().getKiller().getItemInHand() != null){ 
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  			dropeos.add(1);dropeos.add(1);dropeos.add(1);dropeos.add(1);}}dropeos.add(1);}}}
		  		  if(event.getEntity() instanceof Skeleton) {
		  			  if(event.getEntity().getType().equals(EntityType.SKELETON)){
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 0); 
		  			  head.setItemMeta(skullMeta);
		  			  if(dropeos.size() >= 100){
		  				  event.getDrops().add(head);
		  				  dropeos.clear();}
		  			 if(event.getEntity().getKiller() instanceof Player){
			  				if(event.getEntity().getKiller().getItemInHand() != null){  
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				dropeos.add(1);dropeos.add(1);dropeos.add(1);dropeos.add(1);}}
		  			dropeos.add(1);}}}
		  		  if(event.getEntity() instanceof Player) {
		  			  Player p = (Player)event.getEntity();
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner(p.getPlayer().getDisplayName());
		  			  head.setItemMeta(skullMeta);
		  			  if(dropeos.size() >= 100){
		  				  event.getDrops().add(head);
		  				  dropeos.clear();}
		  			 if(event.getEntity().getKiller() instanceof Player){
			  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				dropeos.add(1);dropeos.add(1);dropeos.add(1);dropeos.add(1);}}dropeos.add(1);}}
		  		  if(event.getEntity() instanceof Creeper) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 4); // 4 is for Creeper head
		  			  head.setItemMeta(skullMeta);
		  			  if(dropeos.size() >= 100){
		  				  event.getDrops().add(head);
		  				  dropeos.clear();}
		  			 if(event.getEntity().getKiller() instanceof Player){
			  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				dropeos.add(1);dropeos.add(1);dropeos.add(1);dropeos.add(1);}}dropeos.add(1);}}}}
