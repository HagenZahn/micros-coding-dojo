
class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAXIMUM_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;
    Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name != SULFURAS) {
                item.sellIn = item.sellIn - 1;

                if (item.name == BACKSTAGE_PASSES) {
                    updateBackstagePasses(item);
                } else if (item.name == AGED_BRIE) {
                    updateBrie(item);
                } else {
                    decreaseQuality(item);
                }
                if (item.sellIn < 0) {
                    if (item.name != AGED_BRIE) {
                        if (item.name != BACKSTAGE_PASSES) {
                            decreaseQuality(item);
                        } else {
                            item.quality = 0;
                        }
                    } else {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    private void updateBrie(Item item) {
        increaseQuality(item);
    }

    private void updateBackstagePasses(Item item) {
        increaseQuality(item);
        if (item.sellIn < 10) {
            increaseQuality(item);
        }
        if (item.sellIn < 5) {
            increaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

}

