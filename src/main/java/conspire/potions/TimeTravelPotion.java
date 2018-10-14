package conspire.potions;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;

import conspire.actions.TimeTravelAction;

public class TimeTravelPotion extends AbstractPotion {
    public static final String POTION_ID = "conspire:TimeTravelPotion";
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);
    public static final String NAME = potionStrings.NAME;
    public static final String[] DESCRIPTIONS = potionStrings.DESCRIPTIONS;

    public TimeTravelPotion() {
        super(NAME, POTION_ID, PotionRarity.RARE, PotionSize.H, PotionColor.BLUE);
        this.potency = this.getPotency();
        this.description = DESCRIPTIONS[0];
        this.isThrown = false;
        this.tips.add(new PowerTip(this.name, this.description));
    }

    @Override
    public void use(AbstractCreature target) {
        AbstractDungeon.actionManager.addToBottom(new TimeTravelAction());
    }

    @Override
    public AbstractPotion makeCopy() {
        return new TimeTravelPotion();
    }

    @Override
    public int getPotency(int ascensionLevel) {
        return 1;
    }
}
