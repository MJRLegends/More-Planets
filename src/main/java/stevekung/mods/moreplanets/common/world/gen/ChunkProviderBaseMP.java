/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.perlin.NoiseModule;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import micdoodle8.mods.galacticraft.core.world.gen.EnumCraterSize;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderGenerate;
import stevekung.mods.moreplanets.common.entities.EntityEvolvedWitch;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;

public abstract class ChunkProviderBaseMP extends ChunkProviderGenerate
{
    protected NoiseModule noiseGen1;
    protected NoiseModule noiseGen2;
    protected NoiseModule noiseGen3;
    protected NoiseModule noiseGen4;
    protected World worldObj;
    protected Random rand;
    private int CHUNK_SIZE_X = 16;
    private int CHUNK_SIZE_Y = 128;
    private int CHUNK_SIZE_Z = 16;

    public ChunkProviderBaseMP(World world, long seed, boolean genFeature)
    {
        super(world, seed, genFeature, "");
        this.worldObj = world;
        this.rand = new Random(seed);
        this.noiseGen1 = new Gradient(this.rand.nextLong(), 4, 0.25F);
        this.noiseGen2 = new Gradient(this.rand.nextLong(), 4, 0.25F);
        this.noiseGen3 = new Gradient(this.rand.nextLong(), 1, 0.25F);
        this.noiseGen4 = new Gradient(this.rand.nextLong(), 1, 0.25F);
    }

    public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer chunk)
    {
        this.noiseGen1.setFrequency(0.0125F);
        this.noiseGen2.setFrequency(0.015F);
        this.noiseGen3.setFrequency(0.01F);
        this.noiseGen4.setFrequency(0.02F);

        for (int x = 0; x < this.CHUNK_SIZE_X; x++)
        {
            for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
            {
                double d = this.noiseGen1.getNoise(x + chunkX * 16, z + chunkZ * 16) * 8;
                double d2 = this.noiseGen2.getNoise(x + chunkX * 16, z + chunkZ * 16) * 24;
                double d3 = this.noiseGen3.getNoise(x + chunkX * 16, z + chunkZ * 16) - 0.1;
                d3 *= 4;

                double yDev = 0;

                if (d3 < 0.0D)
                {
                    yDev = d;
                }
                else if (d3 > 1.0D)
                {
                    yDev = d2;
                }
                else
                {
                    yDev = d + (d2 - d) * d3;
                }

                for (int y = 0; y < this.CHUNK_SIZE_Y; y++)
                {
                    if (y < this.getTerrainHeight() + yDev)
                    {
                        chunk.setBlockState(this.getIndex(x, y, z), this.getBaseBlock().getStateFromMeta(this.getBlockMetadata()[2]));
                    }
                }
            }
        }
    }

    @Override
    public void func_180517_a(int chunkX, int chunkZ, ChunkPrimer chunk, BiomeGenBase[] biomeGen)
    {
        int var5 = 20;

        for (int x = 0; x < 16; ++x)
        {
            for (int z = 0; z < 16; ++z)
            {
                int noise = (int) (this.noiseGen4.getNoise(x + chunkX * 16, z * chunkZ * 16) / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
                int var13 = -1;
                Block topBlock = this.getBaseBlock();
                int topBlockMeta = this.getBlockMetadata()[0];
                Block fillBlock = this.getBaseBlock();
                int fillBlockMeta = this.getBlockMetadata()[1];

                for (int y = 255; y >= 0; --y)
                {
                    int index = this.getIndex(x, y, z);

                    if (y <= 0 + this.rand.nextInt(5))
                    {
                        chunk.setBlockState(index, Blocks.bedrock.getDefaultState());
                    }
                    else
                    {
                        Block block = chunk.getBlockState(index).getBlock();

                        if (Blocks.air == block)
                        {
                            var13 = -1;
                        }
                        else if (block == this.getBaseBlock())
                        {
                            if (var13 == -1)
                            {
                                if (noise <= 0)
                                {
                                    topBlock = Blocks.air;
                                    topBlockMeta = 0;
                                    fillBlock = this.getBaseBlock();
                                    fillBlockMeta = this.getBlockMetadata()[1];
                                }
                                else if (y >= var5 - -16 && y <= var5 + 1)
                                {
                                    topBlock = this.getBaseBlock();
                                    topBlockMeta = this.getBlockMetadata()[0];
                                    topBlock = this.getBaseBlock();
                                    topBlockMeta = this.getBlockMetadata()[1];
                                }

                                var13 = noise;

                                if (y >= var5 - 1)
                                {
                                    chunk.setBlockState(index, topBlock.getStateFromMeta(topBlockMeta));
                                }
                                else if (y < var5 - 1 && y >= var5 - 2)
                                {
                                    chunk.setBlockState(index, fillBlock.getStateFromMeta(fillBlockMeta));
                                }
                            }
                            else if (var13 > 0)
                            {
                                --var13;
                                chunk.setBlockState(index, fillBlock.getStateFromMeta(fillBlockMeta));
                            }
                        }
                    }
                }
            }
        }
    }

    public void createCraters(int chunkX, int chunkZ, ChunkPrimer chunk)
    {
        for (int cx = chunkX - 2; cx <= chunkX + 2; cx++)
        {
            for (int cz = chunkZ - 2; cz <= chunkZ + 2; cz++)
            {
                for (int x = 0; x < this.CHUNK_SIZE_X; x++)
                {
                    for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
                    {
                        if (this.getCraterChance() > 0)
                        {
                            if (Math.abs(this.randFromPoint(cx * 16 + x, (cz * 16 + z) * 1000)) < this.noiseGen4.getNoise(x * this.CHUNK_SIZE_X + x, cz * this.CHUNK_SIZE_Z + z) / this.getCraterChance())
                            {
                                Random random = new Random(cx * 16 + x + (cz * 16 + z) * 5000);
                                EnumCraterSize cSize = EnumCraterSize.sizeArray[random.nextInt(EnumCraterSize.sizeArray.length)];
                                int size = random.nextInt(cSize.MAX_SIZE - cSize.MIN_SIZE) + cSize.MIN_SIZE;
                                this.makeCrater(cx * 16 + x, cz * 16 + z, chunkX * 16, chunkZ * 16, size, chunk);
                            }
                        }
                    }
                }
            }
        }
    }

    public void makeCrater(int craterX, int craterZ, int chunkX, int chunkZ, int size, ChunkPrimer chunk)
    {
        for (int x = 0; x < this.CHUNK_SIZE_X; x++)
        {
            for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
            {
                double xDev = craterX - (chunkX + x);
                double zDev = craterZ - (chunkZ + z);

                if (xDev * xDev + zDev * zDev < size * size)
                {
                    xDev /= size;
                    zDev /= size;
                    double sqrtY = xDev * xDev + zDev * zDev;
                    double yDev = sqrtY * sqrtY * 6;
                    yDev = 5 - yDev;
                    int helper = 0;

                    for (int y = 127; y > 0; y--)
                    {
                        if (Blocks.air != chunk.getBlockState(this.getIndex(x, y, z)).getBlock() && helper <= yDev)
                        {
                            chunk.setBlockState(this.getIndex(x, y, z), Blocks.air.getDefaultState());
                            helper++;
                        }
                        if (helper > yDev)
                        {
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean chunkExists(int chunkX, int chunkZ)
    {
        return true;
    }

    @Override
    public boolean unloadQueuedChunks()
    {
        return false;
    }

    @Override
    public int getLoadedChunkCount()
    {
        return 0;
    }

    private int getIndex(int x, int y, int z)
    {
        return (x * 16 + z) * 256 + y;
    }

    private double randFromPoint(int x, int z)
    {
        int n;
        n = x + z * 57;
        n = n << 13 ^ n;
        return 1.0 - (n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff) / 1073741824.0;
    }

    @Override
    public boolean saveChunks(boolean save, IProgressUpdate update)
    {
        return true;
    }

    @Override
    public boolean canSave()
    {
        return true;
    }

    @Override
    public String makeString()
    {
        return this.getName() + "LevelSource";
    }

    @Override
    public List func_177458_a(EnumCreatureType type, BlockPos pos)
    {
        if (type == EnumCreatureType.MONSTER)
        {
            List monsters = new ArrayList();
            monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, 4, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, 4, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 100, 4, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 100, 4, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedWitch.class, 5, 1, 1));
            return monsters;
        }
        return null;
    }

    protected int getCraterChance()
    {
        return 300;
    }

    protected int getTerrainHeight()
    {
        return 64;
    }

    protected abstract String getName();
    protected abstract Block getBaseBlock();
    protected abstract int[] getBlockMetadata();
}