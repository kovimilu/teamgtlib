Feladat - Vidámpark szimulátor

A játékos egy kezdő területtel kezd (a bejáraton kívül teljesen üres terület), ahová tud építkezni, majd vendégek érkeznek, a megnyitás után, akik pénzt költenek és a kedvük befolyásolja meddig maradnak. A játék akkor ér véget, ha elfogy a pénze a játékosnak. (lehet bővíteni, ekkor mindenképpen vége)

Részletek:

Lehetséges építmények:
			- út
			- vendéglátó helyek(éttermek)
			- hullámvasutak (kb 5 különböző fajta)
			- kuka
			- parkosítás (pontosan: fa, bokor, fű)

Építmények részletei: Mindnek van építési költsége. Látni kell, hogy: épülnek, üzemelnek vagy javítás alatt állnak.

	* Utak: Az npc-k csak utakon tudnak közlekedni, ha valami nincs összekötve 		
	úttal azt nem érik el.
	
	* Vendéglátó helyek: Itt tudnak ételt és italt venni a vendégek, az árukat kifizetik, ebből bevétel származik. A vendégek, ha itt vásárolnak szemét keletkezik, ha nincs kuka a közelben eldobják az útra.

	* Hullámvasutak: Rendelkezik építési idővel, menetidő, férőhelyek száma (esetleg mennyivel növeli a hangulatot). Le lehet bontani. El tud romolni, 	használat hatására, a karbantartó javítja meg. Hogy felüljenek rá a vendégek fizetniük kell, az árat a játékos szabja meg. Ha betelnek a férőhelyek rajta rögtön elindul, ha nem akkor egy bizonyos idő után indul el.

	*Kukák: Ide dobhatják a szemetet a vendégek, sosem telik be, viszont valahogy balance-olni kell (pl.: max kukaszám, drága, ronthatják a hangulatot)

	*Parkosítás: 1x1-es méret, javítják a vendégek hangulatát

NPC-k fajtái:

                - vendégek
                - alkalmazottak : takarítók, éttermi dolgozók, karbantartók

NPC-k részletei: 

	* vendégek: Van kedv szintjük és végtelen pénzük. A megnyitó után érkeznek folyamatosan a vidámparkba. Ha vásárolnak ételt vagy italt és nincs kuka a közelben szemetelnek. Ha túl drága egy hullámvasút kevesebb eséllyel ülnek fel rá. 
    A kedvük határozza meg meddig maradnak a parkban, illetve hogy milyen eséllyel ülnek fel egy-egy hullámvasútra. Ha lemegy nullára, akkor távoznak. A kedvüket befolyásolja: eldobott szemét, sorban állás (nagatívan), játékok használata, evés/ivás (pozitívan). 
	
    * alkalmazottak: Időközben mindegyik alkalmazott fizetést kap. El lehet őket bocsátani. 

			- takarítók: járkálnak az utakon és az útjukba került szemetet feltakarítják (egy kis ideig kell takarítaniuk)
			- éttermi dolgozók:
			- karbantartók: megjavítják az elromlott hullámvasutakat, mikor elromlik valamelyik rögtön odamegy a legrövidebb úton.

Költségek:
	   * építmények: mindig kifizeti a játékos amikor lerakja a helyére
	   * alkalmazottak munkabére: bizonyos időközönként automatikusan levonódik
	   * üzemeltetséi költség: a belépőjegy árából és az ételek/italok árából 	   amutomatikus levonódik (tehát kevesebb pénzt kap meg a játékos)

Útkeresés:
    Mindenki a legrövidebb úton megy a dolgára. Gráfábrázolás -> szélességi keresés. A vendégek véletlenszerűen választanak egy helyszínt és a legrövidebb úton odamennek, viszont bele kell kalkulálni a kedvüket, a sort stb.

Egyéb dolgok:
		- nem kell zoomolni, egy ablakban látjuk az egész területet
		- nem kell animálni
		- a bevételt nem kell lebontani külön összegekre, egybe látja a játékos
		- időjárás nincs, a park nem zár be (folyamatosan üzemel)
		- ha bezáródik a játékablak, a játéknak vége (nem kell elmenteni az állapotot)
		- be lehet állítani a maximum számát a vendégeknek (nem kötelező)
		- a vendégek átmehetnek egymásan, nem kell rendes sorban állniuk
		