package com.craftilandia.mobmask;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Horse;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
	
	ArrayList<Integer> dropeos = new ArrayList<Integer>();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().getDefaults();
		int rate = getConfig().getInt("rate");
		getConfig().set("rate", rate);		
		saveConfig();
		}
	
	@EventHandler
	public void damage(EntityDamageEvent e){	
		if (e.getEntity() instanceof Player){

		Player p = (Player)e.getEntity();
		if(p.hasPermission("mobmask.use")){
		if (p.getInventory().getHelmet() != null) {//check if null. very important
			if(p.getInventory().getHelmet().getType().equals(Material.SKULL_ITEM)){
				e.setCancelled(true);}}
		}}}//Monsters set to make no damage
			
	  @EventHandler
	  public void onEntityDeath(EntityDeathEvent event){
		  
		  if(event.getEntity() instanceof Zombie) {
			  
			  LivingEntity entity = event.getEntity();
  			  if ((entity instanceof PigZombie)) {
  				ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
	  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
	  			  head.setDurability((short) 3); // 3 is for player head
	  			  skullMeta.setOwner("MHF_PigZombie");
	  			  head.setItemMeta(skullMeta);
	  			if (dropeos.isEmpty()) {
	  				  dropeos.add(1); 
	  			}
	  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
	  				  event.getDrops().add(head);
	  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Pigman");
	  				  dropeos.clear();
	  				  dropeos.add(1);}
	  			  if(event.getEntity().getKiller() instanceof Player){
	  				int total = dropeos.get(0) + 1;		  				
	  				if(event.getEntity().getKiller().getItemInHand() != null){
	  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
	  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
	  				total = dropeos.get(0) + level;
	  				}}
	  				dropeos.set(0, total);
	  				}
  			  }
  			  else{
		  			  if(event.getEntity().getType().equals(EntityType.ZOMBIE)){
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 2);
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); }
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Zombie");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}}}
		  
		  		  if(event.getEntity() instanceof Skeleton) {
		  			  if(event.getEntity().getType().equals(EntityType.SKELETON)){
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 0); 
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Skeleton");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}}
		  		  
		  		  if(event.getEntity() instanceof Player) {
		  			  Player p = (Player)event.getEntity();
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner(p.getPlayer().getDisplayName());
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); }
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated " + p.getPlayer().getName());
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		  if(event.getEntity() instanceof Creeper) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 4); // 4 is for Creeper head
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); }
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Creeper");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Spider) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			
		  			  LivingEntity entity = event.getEntity();
		  			  if ((entity instanceof CaveSpider)) {
		  				skullMeta.setOwner("MHF_CaveSpider");}
		  			  else{
		  				skullMeta.setOwner("MHF_Spider");
		  			  }
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Spider");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Enderman) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Enderman");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Enderman");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Guardian) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("Blu3B3ar_");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Guardian");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		
		  		if(event.getEntity() instanceof Rabbit) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("Master0r0");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Rabbit");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Bat) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("PUNKwithFUNK");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Bat");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Silverfish) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("Quex");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a SilverFish");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Witch) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("WIbigdog");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Witch");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Wolf) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("GoogleChrome");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Wolf");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Snowman) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Pumpkin");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Snowman");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Endermite) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("Whitehman");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Endermite");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Horse) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("pukkapieman");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Horse");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		
		  		
		  		
		  		if(event.getEntity() instanceof Blaze) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Blaze");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Blaze");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Squid) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Squid");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Squid");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof IronGolem) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Golem");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Iron Golem");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		
		  		if(event.getEntity() instanceof Ghast) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Ghast");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Ghast");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Pig) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Pig");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Pig");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Villager) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Villager");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Villager");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Sheep) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Sheep");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Sheep");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Cow) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			LivingEntity entity = event.getEntity();
		  			  if ((entity instanceof MushroomCow)) {
		  				skullMeta.setOwner("MHF_MushroomCow");}
		  			  else{
		  				skullMeta.setOwner("MHF_Cow");
		  			  }		  			  
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Cow");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Chicken) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Chicken");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Chicken");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		if(event.getEntity() instanceof Ocelot) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			  skullMeta.setOwner("MHF_Ocelot");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Ocelot");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		
		  		if(event.getEntity() instanceof Slime) {
		  			  ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
		  			  head.setDurability((short) 3); // 3 is for player head
		  			LivingEntity entity = event.getEntity();
		  			  if ((entity instanceof MagmaCube)) {
		  				skullMeta.setOwner("MHF_LavaSlime");}
		  			  else{
		  				skullMeta.setOwner("MHF_Slime");
		  			  }		  		
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getEntity().getKiller().getName() + " has decapetated a Slime");
		  				  dropeos.clear();
		  				  dropeos.add(1);}
		  			  if(event.getEntity().getKiller() instanceof Player){
		  				int total = dropeos.get(0) + 1;		  				
		  				if(event.getEntity().getKiller().getItemInHand() != null){
		  			if(event.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)){	
		  				int level = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);		  				
		  				total = dropeos.get(0) + level;
		  				}}
		  				dropeos.set(0, total);
		  				}}
		  		
	  
	  
	  }

	  
}
