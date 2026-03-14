# NoHotbarNeeded for Minecraft 1.7.10

## Mod functionality

Mod provides functionality and an interface `net.xonich.mc.nohotbarneeded.api.ActivatableFromInventoryServerSide` 
which other classes can implement in order to be able to activated from players inventory.

## Example: Player needs to open backpack item.
### Prerequisite
Player have backpack in some inventory slot, not hotbar.
### Without mod
* Player opens inventory.
* Player moves item to some hotbar slot which likely already occupied by another item.
* Player closes inventory.
* Player switches active item slot to that which have backpack.
* Player presses right-click.

### With mod
* Player points to backpack item
* Player presses assigned button
