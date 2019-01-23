package gg.rsmod.game.model.region.update

import gg.rsmod.game.message.Message
import gg.rsmod.game.message.impl.SpawnProjectileMessage
import gg.rsmod.game.model.entity.Projectile

/**
 * @author Tom <rspsmods@gmail.com>
 */
class ProjectileSpawnUpdate(override val type: EntityUpdateType,
                            override val entity: Projectile) : EntityUpdate<Projectile>(type, entity) {

    override fun toMessage(): Message = if (entity.targetPawn != null) {
        val targetIndex = if (entity.targetPawn.getType().isNpc()) entity.targetPawn.index + 1 else -(entity.targetPawn.index + 1)
        SpawnProjectileMessage(
                start = ((entity.tile.x and 0x7) shl 4) or (entity.tile.z and 0x7),
                pawnTargetIndex = targetIndex, offsetX = entity.targetTile.x - entity.tile.x, offsetZ = entity.targetTile.z - entity.tile.z,
                gfx = entity.gfx, startHeight = entity.startHeight, endHeight = entity.endHeight,
                delay = entity.delay, lifespan = entity.lifespan, angle = entity.angle, steepness = entity.steepness)
    } else {
        SpawnProjectileMessage(
                start = ((entity.tile.x and 0x7) shl 4) or (entity.tile.z and 0x7),
                pawnTargetIndex = 0, offsetX = entity.targetTile.x - entity.tile.x, offsetZ = entity.targetTile.z - entity.tile.z,
                gfx = entity.gfx, startHeight = entity.startHeight, endHeight = entity.endHeight, delay = entity.delay,
                lifespan = entity.lifespan, angle = entity.angle, steepness = entity.steepness)
    }
}