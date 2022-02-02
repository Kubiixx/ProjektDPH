# První projekt
## Vypracovaný první projekt kurzu - práce se sazbami DPH 28 zemí EU.

### Zadání projektu: 

#### Zadání
Naprogramuj aplikaci v Javě, která vypíše všechny státy Evropské unie, které mají sazbu daně z přidané hodnoty (DPH, VAT) vyšší, než 20 % a nepoužívají speciální sazbu DPH/VAT.

Aktuální data o jednotlivých státech a jejich daních dostaneš v souboru — vzorový soubor je ke stažení zde: vat-eu.csv.

Vstupní soubor bude ve stejné složce, jako projekt aplikace.

#### Formát vstupního souboru
Na každém řádku vstupního souboru jsou informace o jednom státu v následujícím formátu:
zkratka státu (například AT)
název státu (Austria)
plná sazba daně z přidané hodnoty v procentech (20)
snížená sazba daně z přidané hodnoty v procentech (10)
informace o tom, jestli země používá speciální sazbu DPH pro některé produkty (true/false)
Jednotlivé hodnoty jsou odděleny vždy tabulátorem.

#### Výstup aplikace

Postupně zpracuj tyto kroky:
Načti ze souboru všechna data do vhodné datové struktury (vytvoř třídu pro uložení dat).
Vypiš seznam všech států a u každého uveď základní sazbu daně z přidané hodnoty ve formátu podle vzoru:
Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z přidané hodnoty vyšší než 20 % a přitom nepoužívají speciální sazbu daně.
Výpis z bodu 3. seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s nejvyšší sazbou).
Pod výpis z bodu 3. doplň řádek s rovnítky pro oddělení a poté seznam zkratek států, které ve výpisu nefigurují. Opět dodrž formát podle vzoru (místo tří teček budou další státy):
Výsledný výpis zapiš také do souboru s názvem vat-over-20.txt. Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)
Doplň možnost, aby uživatel z klávesnice zadal výši sazby DPH/VAT, podle které se má filtrovat. Vypíší se tedy státy se základní sazbou vyšší než ta, kterou uživatel zadal.
Pokud uživatel zmáčkne pouze Enter, jako výchozí hodnota se použij jako výchozí sazbu 20 %.
Uprav název výstupního souboru tak, aby reflektoval zadanou sazbu daně. Například pro zadanou sazbu 17 % se vygeneruje soubor vat-over-17.txt a pro sazbu 25 % se vygeneruje soubor vat-over-25.txt.
