
insert into factor_options (value, label, type) values ('PZS', 'Panonske zaslanjene stepe', 'type');
insert into factor_options (value, label, type) values ('SPKP', 'Suvi peskoviti krečnjački pašnjaci', 'type');
insert into factor_options (value, label, type) values ('PSPNL', 'Panonski stepski pašnjaci na lesu', 'type');
insert into factor_options (value, label, type) values ('SLVTKSK', 'Sekundarne livade sa visokom travom koja se kosi', 'type');
insert into factor_options (value, label, type) values ('LS', 'Listopadne šume', 'type');
insert into factor_options (value, label, type) values ('CS', 'Četinarske šume', 'type');
insert into factor_options (value, label, type) values ('SLZ', 'Suve livade sa žbunjem', 'type');
insert into factor_options (value, label, type) values ('PZ', 'Poljoprivredna zemljišta', 'type');
insert into factor_options (value, label, type) values ('PP', 'Planinski pašnjaci', 'type');
insert into factor_options (value, label, type) values ('BMS', 'Barska i močvarna staništa', 'type');

insert into factor_options (value, label, type) values ('NoElevation', '0-200mv', 'elevation');
insert into factor_options (value, label, type) values ('ExtraSmall', '200-600mv', 'elevation');
insert into factor_options (value, label, type) values ('Small', '600-800mv', 'elevation');
insert into factor_options (value, label, type) values ('Medium', '800-1200mv', 'elevation');
insert into factor_options (value, label, type) values ('Large', '1200-2000mv', 'elevation');
insert into factor_options (value, label, type) values ('ExtraLarge', '2100-2600mv', 'elevation');

insert into factor_options (value, label, type) values ('NoExposition', 'Ravno područje', 'exposition');
insert into factor_options (value, label, type) values ('North', 'Sever', 'exposition');
insert into factor_options (value, label, type) values ('NorthWest', 'Severo-zapad', 'exposition');
insert into factor_options (value, label, type) values ('NorthEast', 'Severo-istok', 'exposition');
insert into factor_options (value, label, type) values ('East', 'Istok', 'exposition');
insert into factor_options (value, label, type) values ('West', 'Zapad', 'exposition');
insert into factor_options (value, label, type) values ('South', 'Jug', 'exposition');
insert into factor_options (value, label, type) values ('SouthEast', 'Jugo-istok', 'exposition');
insert into factor_options (value, label, type) values ('SouthWest', 'Jugo-zapad', 'exposition');

insert into factor_options (value, label, type) values ('ExtraCold', '5-10C', 'mjt');
insert into factor_options (value, label, type) values ('VeryCold', '10-15C', 'mjt');
insert into factor_options (value, label, type) values ('Cold', '15-20C', 'mjt');
insert into factor_options (value, label, type) values ('Medium', '20-25C', 'mjt');
insert into factor_options (value, label, type) values ('Hot', '25-30C', 'mjt');
insert into factor_options (value, label, type) values ('VeryHot', '30-35C', 'mjt');

-- proveriti labele
insert into factor_options (value, label, type) values ('None', 'Nema plavljenja', 'flooding');
insert into factor_options (value, label, type) values ('Rarely', 'Retko plavljenje', 'flooding');
insert into factor_options (value, label, type) values ('Sometimes', 'Povremeno plavljenje', 'flooding');
insert into factor_options (value, label, type) values ('Often', 'Često plavljenje', 'flooding');

-- proveriti labele
insert into factor_options (value, label, type) values ('NoSlope', 'Nema nagiba (0%)', 'slope');
insert into factor_options (value, label, type) values ('Small', 'Mali nagib (10%)', 'slope');
insert into factor_options (value, label, type) values ('Medium', 'Srednji nagib (20%)', 'slope');
insert into factor_options (value, label, type) values ('Great', 'Veliki nagib (40%)', 'slope');

-- ANTROPOLOSKI FAKTORI NAZIV FAKTORA, OPIS, PREPORUKA I BROJNA VREDNOST KOLIKO JE STETNO
--zbunje
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema žbunastih vrsta na staništu', 'shrubbery', 0, 'Nije potrebno preduzeti nikakve akcije.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Žbunaste vrste su veoma retke i malobrojne', 'shrubbery', 3, 'Neophodno je pratiti razvoj žbunastih vrsta i povremeno ih uklanjati.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Žbunaste vrste su relativno brojne', 'shrubbery', 5, 'Brojne žbunaste vrste potrebno je mehanički uklanjati i redovno održavati.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Žbunaste vrste su veoma brojne', 'shrubbery', 10, 'Ovo je veoma nepovoljna situacija koja se ne može rešiti ni mehaničkim uklanjanjem žbunastih vrsta.');

--udaljenost od susedne populacije
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Najbliža susedna populacija je udaljena više kilometara', 'distanceToNeighbourhoodPopulation', 10, 'Udaljenost do najbliže susedne populacije nije povoljna ali ovo nije limitirajući faktor. Ukoliko je moguće, poželjno bi bilo naći stanište sa bližom susednom populacijom.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Susedna populacija je udaljena manje 1km ali je između njih neka barijera', 'distanceToNeighbourhoodPopulation', 5, 'Udaljenost do najbliže susedne populacije je relativno nepovoljna ali ovo nije limitirajući faktor. Ukoliko je moguće, poželjno bi bilo naći stanište sa bližom susednom populacijom.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Susedna populacija je veoma blizu i postoji mogućnost kontakta jedinki', 'distanceToNeighbourhoodPopulation', 0, 'Nije potrebno preduzeti nikakve akcije.');

--hvatanje trovanje, krivolov
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema', 'disturbance', 0, 'Nije potrebno preduzeti nikakve akcije.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Veoma retko', 'disturbance', 3, 'Sitacija je relativno nepovoljna, i nije porebno preduzeti drastične mere.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('U manjoj meri', 'disturbance', 6, 'Nepovoljna situacija, neophodno je raditi na edukaciji stanovništva.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Veoma često', 'disturbance', 10, 'Izuzetno nepovoljna situacija, neophodno je raditi na edukaciji stanovništva');

--saobracaj
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište preseca jedan ili više asfaltnih puteva', 'roads', 9, '(Postojanje asfaltnih puteva može nepovoljno uticati na opstanak populacija ali i ne mora ukoliko saobraćaj nije intenzivan. Prilikom izbora staništa za naseljavanje tekunica prioritet treba uvek dati onima bez bez asfaltnih puteva)');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište se graniči sa asfaltnim putem', 'roads', 7, 'Postojanje asfaltnog puta u graničnim područjima staništa ne predstavljaj direktnu pretnju zbog čega ovakva staništa mogu biti izabrana za naseljavanje tekunica ali prioritet treba uvek dati onima bez bez asfaltnih puteva');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište preseca ili se ono graniči sa zemljanim putem', 'roads', 3, '(Zemljanim putevima se najčešće kreću poljoprivredne mašine što znači da je frekvencija saobraćaja niska i samim tim ovakva staništa su dobar izbor za naseljavanje tekunica ukoliko su i svi drugi faktori povoljni)');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema puteva na staništu', 'roads', 0, 'Nije potrebno preduzeti nikakve akcije.');

-- poljoprivreda
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište u potpunosti uokvireno poljoprivrednim zemljištem', 'agriculture', 10, 'Veoma nepovoljna situacija zbog potencijalnog trovanja pesticidima.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište se jednim delom dodiruje sa poljoprivrednim zemljištem', 'agriculture', 5, 'Tekunice mogu biti ugrožene zbog potencijalnog trovanja pesticidima.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema poljoprivrednog zemljišta u neposrednoj blizini staništa', 'agriculture', 0, 'Nije potrebno preduzeti nikakve akcije.');

--ispasa
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu se redovno napasaju ovce/krave', 'grazing', 0, 'Nije potrebno preduzeti nikakve akcije.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu se povremeno ili u manjem obimu napasaju ovce/krave ispaše', 'grazing', 3, 'Ukoliko je moguće u saradnji sa lokalnom zajednicom raditi na podsticanju razvoja stočarstva');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu nema ispaše', 'grazing', 6, 'Ukoliko je moguće u saradnji sa lokalnom zajednicom raditi na podsticanju razvoja stočarstva');

--uklanjanje trave
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema uklanjanja trave', 'grassRemoving', 0, 'Nije potrebno preduzeti nikakve akcije.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Ima uklanjanja trave', 'grassRemoving', 7, 'Za uspešnost naseljavanja tekunica neophodno je potpuno prekinuti ovakav vid eksploatacije zemljišta na konkretnom staništu');

--predatori
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu nisu primećeni potencijalni predatori', 'predators', 0, 'Nije potrebno preduzeti nikakve akcije.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu su primećeni potencijalni predatori', 'predators', 4, 'Potrebno je pratiti u kojoj meri prirodni predatori utiču na tekunice. U većini slučajeva oni su manje opasni u osnosu na domaće mačke, kojih ima u blizini ljudskih staništa.');

--da li staniste ima vid zastite
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Ima', 'protection', 0, 'Nije potrebno preduzeti nikakve akcije.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema', 'protection', 5, 'VLasnici parcela su svakako u obavezi da postupaju u skladu sa propisanim merama zaštite. Ukoliko je neophodno treba obavestiti građane o novim merama koje se potencijalno donesu.');

--vlasnistvo i namena parcele
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Opštinsko', 'purpose', 0, 'Nije potrebno preduzeti nikakve akcije.');
insert into anthropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Privatno', 'purpose', 5, 'Vlasniik parcele je u obaveti da se pridržava zakona o zaštiti prirode. Neophodno je uspostaviti kontakt sa vlasnikom i obavestiti ga o merama koje je potrebno da poštuje.');

--useri
insert into users (username, password, first_name, last_name) values ('isidora', '$2y$10$t4NZP3qGGdzGakospEzFHOPQngmjvi7dZeZSiwfiNz.1rv/smO0Ce', 'Isidora', 'Savić');

--prirodni faktori
insert into natural_factors (type, elevation, mjt, exposition, slope, flooding) values ('PZS', 'NoElevation', 'Medium', 'South', 'NoSlope',  'None');

--stanista
insert into habitats (name, label, natural_factors_id, user_id, date_created) values ('Neradin', 'OPTIMAL', 1, 1, '2022-05-10');

--ljudski faktori
insert into anthropological_factors (shrubbery_id, distance_id, disturbance_id, roads_id, agriculture_id, grazing_id, grass_removing_id, predators_id, protection_id, purpose_id, habitat_id, date_created)
                    values (1, 5, 8, 12,16, 19, 22, 24, 26, 28, 1, '2022-05-10');
