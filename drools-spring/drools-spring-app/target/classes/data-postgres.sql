
insert into factor_options (value, label, type) values ('PZS', 'Panonske zaslanjene stepe', 'type');
insert into factor_options (value, label, type) values ('SPKP', 'Suvi peskoviti krečnjački pašnjaci', 'type');
insert into factor_options (value, label, type) values ('PSPNL', 'Panonski stepski pašnjaci na lesu', 'type');
insert into factor_options (value, label, type) values ('SLVTKSK', 'Sekundarne livade sa visokom travom koja se kosi', 'type');
insert into factor_options (value, label, type) values ('LS', 'Listopadne šume', 'type');
insert into factor_options (value, label, type) values ('CS', 'Četinarske šume', 'type');
insert into factor_options (value, label, type) values ('SLZ', 'Suve livade sa žbunjem', 'type');
insert into factor_options (value, label, type) values ('PP', 'Poljoprivredna zemljišta', 'type');
insert into factor_options (value, label, type) values ('PZ', 'Planinski pašnjaci', 'type');
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
-- TODO: dodati preporuke svuda i levele namestiti

--zbunje
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema žbunastih vrsta na staništu', 'shrubbery', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Žbunaste vrste su veoma retke i malobrojne', 'shrubbery', 0, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Žbunaste vrste su relativno brojne', 'shrubbery', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Žbunaste vrste su veoma brojne', 'shrubbery', 0, '');

--udaljenost od susedne populacije
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Najbliža susedna populacija je udaljena više kilometara', 'distanceToNeighbourhoodPopulation', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Susedna populacija je udaljena manje 1km ali je između njih neka barijera (npr. urbano područje, poljoprivredno zemljište...)', 'distanceToNeighbourhoodPopulation', 0, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Susedna populacija je veoma blizu i postoji mogućnost kontakta jedinki', 'distanceToNeighbourhoodPopulation', 2, '');

--hvatanje trovanje, krivolov
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema', 'disturbance', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Veoma retko', 'disturbance', 0, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('U manjoj meri', 'disturbance', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Veoma često', 'disturbance', 0, '');

--saobracaj
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište preseca jedan ili više asfaltnih puteva', 'roads', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište se graniči sa asfaltnim putem', 'roads', 0, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište preseca ili se ono graniči sa zemljanim putem', 'roads', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema puteva na staništu', 'roads', 0, '');

-- poljoprivreda
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište u potpunosti uokvireno poljoprivrednim zemljištem', 'agriculture', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Stanište se jednim delom dodiruje sa poljoprivrednim zemljištem', 'agriculture', 0, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema poljoprivrednog zemljišta u neposrednoj blizini staništa', 'agriculture', 2, '');

--ispasa
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu se redovno napasaju ovce/krave', 'grazing', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu se povremeno ili u manjem obimu napasaju ovce/krave ispaše', 'grazing', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu nema ispaše', 'grazing', 0, '');

--uklanjanje trave
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema uklanjanja trave', 'grassRemoving', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Ima uklanjanja trave', 'grassRemoving', 2, '');

--predatori
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu su primećeni potencijalni predatori', 'predators', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Na staništu nisu primećeni potencijalni predatori', 'predators', 0, '');

--da li staniste ima vid zastite
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Ima', 'protection', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Nema', 'protection', 0, '');

--vlasnistvo i namena parcele
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Opštinsko', 'purpose', 2, '');
insert into atropological_factor_level_and_description (description, factor_name, level, recommendation)
values ('Privatno', 'purpose', 0, '');

--useri
insert into users (username, password, first_name, last_name) values ('isidora', '$2y$10$t4NZP3qGGdzGakospEzFHOPQngmjvi7dZeZSiwfiNz.1rv/smO0Ce', 'Isidora', 'Savić');

--prirodni faktori
insert into natural_factors (type, elevation, mjt, exposition, slope, flooding) values ('PZS', 'NoElevation', 'Medium', 'South', 'NoSlope',  'None');

--ljudski faktori
insert into antropological_factors (shrubbery_id, distance_id, disturbance_id, roads_id, agriculture_id, grazing_id, grass_removing_id, predators_id, protection_id, purpose_id, date_added)
values (1, 1, 1, 1, 1, 1, 1, 1, 1, 1, '2022-05-10');

--stanista
insert into habitats (name, label, natural_factors_id,antropological_factors_id, user_id, date_created) values ('Livadica', 'OPTIMAL', 1, 1, 1, '2022-05-10');
