package com.craftilandia.mobmask;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
import org.bukkit.entity.Monster;
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
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
	
	ArrayList<Integer> dropeos = new ArrayList<Integer>();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyHeader();
		getConfig().options().copyDefaults(true);
		if(getConfig().getString("rate") == null){
			getConfig().set("rate", 300);
		}
		if(getConfig().getString("deathmsg") == null){
			getConfig().set("deathmsg", "&aKILLER &fhas decapetated a &4VICTIM");
		}
		saveConfig();
		}
	
	@EventHandler
	public void noami(EntityTargetLivingEntityEvent e){
		if (e.getTarget() instanceof Player){

			Player p = (Player)e.getTarget();
			if(p.hasPermission("mobmask.use") && e.getEntity() instanceof Monster){
			if (p.getInventory().getHelmet() != null) {//check if null. very important
				if(p.getInventory().getHelmet().getType().equals(Material.SKULL_ITEM)){
					e.setCancelled(true);}}
			}}
	}
	
			
	  @EventHandler
	  public void onEntityDeath(EntityDeathEvent event){
		  
		  if(event.getEntity().getKiller() instanceof Player){
		  String getmsg = getConfig().getString("deathmsg").replace("KILLER", event.getEntity().getKiller().getName()).replace("VICTIM", event.getEntity().getName().toString());
			String msg = ChatColor.translateAlternateColorCodes('&', getmsg);
		  if(event.getEntity() instanceof Zombie) {
			  
			  LivingEntity entity = event.getEntity();
  			  if ((entity instanceof PigZombie)) {
  				ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
	  			  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
	  			  head.setDurability((short) 3); // 3 is for player head
	  			  skullMeta.setOwner("MHF_PigZombie");
	  			  skullMeta.setDisplayName("Pigman Head");
	  			  head.setItemMeta(skullMeta);
	  			if (dropeos.isEmpty()) {
	  				  dropeos.add(1); 
	  			}
	  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
	  				  event.getDrops().add(head);
	  				  Bukkit.broadcastMessage(msg);
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
		  				  Bukkit.broadcastMessage(msg);
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
		  				  Bukkit.broadcastMessage(msg);
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
		  				  Bukkit.broadcastMessage(msg);
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
		  				  Bukkit.broadcastMessage(msg);
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
		  				skullMeta.setOwner("MHF_CaveSpider");
		  				skullMeta.setDisplayName("Cave Spider Head");}
		  			  else{
		  				skullMeta.setOwner("MHF_Spider");
		  				skullMeta.setDisplayName("Spider Head");
		  			  }
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Enderman Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Guardian Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Rabbit Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Bat Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("SilverFish Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Witch Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Wolf Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Snowman Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Endermite Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Horse Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Blaze Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Squid Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("IronGolem Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Ghast Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Pig Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Villager Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Sheep Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  				skullMeta.setOwner("MHF_MushroomCow");
		  				skullMeta.setDisplayName("Mushroom Cow Head");}
		  			  else{
		  				skullMeta.setOwner("MHF_Cow");
		  				skullMeta.setOwner("Cow Head");
		  			  }		  			  
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Chicken Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  			  skullMeta.setDisplayName("Ocelot Head");
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
		  				skullMeta.setOwner("MHF_LavaSlime");
		  				skullMeta.setDisplayName("Lava Slime Head");}
		  			  else{
		  				skullMeta.setOwner("MHF_Slime");
		  				skullMeta.setDisplayName("Slime Head");
		  			  }		  		
		  			  head.setItemMeta(skullMeta);
		  			if (dropeos.isEmpty()) {
		  				  dropeos.add(1); 
		  			}
		  			  if(dropeos.get(0) >= getConfig().getInt("rate")){
		  				  event.getDrops().add(head);
		  				  Bukkit.broadcastMessage(msg);
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
	  

	  
	  @EventHandler
	  public void onBlockBreak(BlockBreakEvent e) {
		if(e.getBlock().getType().equals(Material.SKULL)) {
			if(e.getBlock().getDrops().toString().contains("MHF_Spider")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Spider");
				  skullMeta.setDisplayName("Spider Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_PigZombie")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_PigZombie");
				  skullMeta.setDisplayName("Pigman Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_CaveSpider")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_CaveSpider");
				  skullMeta.setDisplayName("Cave Spider Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Enderman")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Enderman");
				  skullMeta.setDisplayName("Enderman Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("Blu3B3ar_")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("Blu3B3ar_");
				  skullMeta.setDisplayName("Guardian Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("Master0r0")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("Master0r0");
				  skullMeta.setDisplayName("Rabbit Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("PUNKwithFUNK")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("PUNKwithFUNK");
				  skullMeta.setDisplayName("Bat Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("Quex")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("Quex");
				  skullMeta.setDisplayName("SilverFish Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("WIbigdog")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("WIbigdog");
				  skullMeta.setDisplayName("Witch Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("GoogleChrome")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("GoogleChrome");
				  skullMeta.setDisplayName("Wolf Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Pumpkin")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Pumpkin");
				  skullMeta.setDisplayName("Snowman Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("Whitehman")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("Whitehman");
				  skullMeta.setDisplayName("Endermite Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("pukkapieman")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("pukkapieman");
				  skullMeta.setDisplayName("Horse Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Blaze")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Blaze");
				  skullMeta.setDisplayName("Blaze Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Squid")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Squid");
				  skullMeta.setDisplayName("Squid Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Golem")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Golem");
				  skullMeta.setDisplayName("IronGolem Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Ghast")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Ghast");
				  skullMeta.setDisplayName("Ghast Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Pig}")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Pig");
				  skullMeta.setDisplayName("Pig Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Villager")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Villager");
				  skullMeta.setDisplayName("Villager Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Sheep")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Sheep");
				  skullMeta.setDisplayName("Sheep Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Cow")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Cow");
				  skullMeta.setDisplayName("Cow Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_MushroomCow")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_MushroomCow");
				  skullMeta.setDisplayName("Mushroom Cow Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Chicken")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Chicken");
				  skullMeta.setDisplayName("Chicken Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Ocelot")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Ocelot");
				  skullMeta.setDisplayName("Ocelot Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_LavaSlime")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_LavaSlime");
				  skullMeta.setDisplayName("Lava Slime Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			if(e.getBlock().getDrops().toString().contains("MHF_Slime")){  
				  Block block = e.getBlock();
				  block.setType(Material.AIR);
				  ItemStack head = new ItemStack(Material.SKULL_ITEM,1);
				  SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
				  head.setDurability((short) 3); 
				  skullMeta.setOwner("MHF_Slime");
				  skullMeta.setDisplayName("Slime Head");
				  head.setItemMeta(skullMeta);
				block.getWorld().dropItem(e.getPlayer().getLocation(), head);
				  e.setCancelled(true); 
				  }
			
		
		}}
}
