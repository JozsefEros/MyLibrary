INSERT INTO readers (
    first_name,
    middle_name,
    last_name,
    year_of_birth,
    registration_date,
    created_at,
    modified_at)
VALUES
    ('Kiss','Anna','Mária',1992,'2024-05-16','2024-05-16','2024-05-16'),
    ('Nagy','László','József',1985,'2024-05-16','2024-05-16','2024-05-16'),
    ('Szabó','Zoltán','Péter',1990,'2024-05-16','2024-05-16','2024-05-16'),
    ('Kovács','Eszter','Katalin',1995,'2024-05-16','2024-05-16','2024-05-16'),
    ('Tóth','Tamás','András',1988,'2024-05-16','2024-05-16','2024-05-16'),
    ('Horváth','Erika','Júlia',1993,'2024-05-16','2024-05-16','2024-05-16'),
    ('Varga','Gábor','István',1987,'2024-05-16','2024-05-16','2024-05-16'),
    ('Molnár','Réka','Gabriella',1994,'2024-05-16','2024-05-16','2024-05-16'),
    ('Németh','Balázs','Ferenc',1989,'2024-05-16','2024-05-16','2024-05-16'),
    ('Farkas','Ádám','Lőrinc',1991,'2024-05-16','2024-05-16','2024-05-16'),
    ('Balogh','Viktória','Anna',1996,'2024-05-16','2024-05-16','2024-05-16'),
    ('Papp','Attila','Zsolt',1984,'2024-05-16','2024-05-16','2024-05-16'),
    ('Szilágyi','Károly','Miklós',1986,'2024-05-16','2024-05-16','2024-05-16'),
    ('Lakatos','Emese','Tünde',1992,'2024-05-16','2024-05-16','2024-05-16'),
    ('Juhász','Márk','Béla',1983,'2024-05-16','2024-05-16','2024-05-16'),
    ('Mészáros','Anikó','Krisztina',1997,'2024-05-16','2024-05-16','2024-05-16'),
    ('Simon','Dóra','Evelin',1998,'2024-05-16','2024-05-16','2024-05-16'),
    ('Oláh','Lajos','Barnabás',1981,'2024-05-16','2024-05-16','2024-05-16'),
    ('Fekete','Patrik','Dénes',1990,'2024-05-16','2024-05-16','2024-05-16'),
    ('Török','Orsolya','Edit',1994,'2024-05-16','2024-05-16','2024-05-16');

INSERT INTO catalog (
    title,
    author,
    genre,
    published,
    publisher,
    language,
    isbn
)
VALUES

    ('Az Alkimista','Paulo Coelho','Fiction','1988','HarperCollins','Hungarian','9789630572933'),
    ('The Catcher in the Rye','J.D. Salinger','Fiction','1951','Little, Brown and Company','English','9780241950432'),
    ('A Kőszívű Ember Fiai','Jókai Mór','Classics','1869','Magyar Elektronikus Könyvtár','Hungarian','9789632405595'),
    ('Pride and Prejudice','Jane Austen','Romance','1813','Penguin Classics','English','9780141439518'),
    ('A Gyűrűk Ura','J.R.R. Tolkien','Fantasy','1954','Allen & Unwin','Hungarian','9789639534054'),
    ('To Kill a Mockingbird','Harper Lee','Fiction','1960','HarperCollins','English','9780061120084'),
    ('Egri Csillagok','Gárdonyi Géza','Historical Fiction','1901','Európa Könyvkiadó','Hungarian','9789630796520'),
    ('1984','George Orwell','Science Fiction','1949','Penguin Books','English','9780141187761'),
    ('Harry Potter és a Bölcsek Köve','J.K. Rowling','Fantasy','1997','Bloomsbury','Hungarian','9789639556582'),
    ('The Great Gatsby','F. Scott Fitzgerald','Classics','1925','Scribner','English','9780743273565'),
    ('A Pál utcai fiúk','Molnár Ferenc','Classics','1907','Magvető Kiadó','Hungarian','9789631412293'),
    ('Jane Eyre','Charlotte Brontë','Gothic Fiction','1847','Penguin Classics','English','9780141441146'),
    ('The Lord of the Flies','William Golding','Adventure','1954','Faber and Faber','English','9780571084838'),
    ('A Varázshegy','István Fekete','Children`s Literature','1962','Móra Könyvkiadó','Hungarian','9789631172722'),
    ('War and Peace','Leo Tolstoy','Historical Fiction','1869','Wordsworth Editions','English','9781853260629'),
    ('Krisztus Krisztinával','Mikszáth Kálmán','Fiction','1891','Ráth Mór','Hungarian','9789631421189'),
    ('Brave New World','Aldous Huxley','Dystopian Fiction','1932','Vintage Books','English','9780099518471'),
    ('A kis herceg','Antoine de Saint-Exupéry','Children`s Literature','1943','Gallimard','Hungarian','9789630710808'),
    ('Moby-Dick','Herman Melville','Adventure','1851','Wordsworth Editions','English','9781853260087'),
    ('A hattyúk tava','Gyulai Pál','Poetry','1831','Nemzeti Tankönyvkiadó','Hungarian','9789631911288'),
    ('Frankenstein','Mary Shelley','Gothic Fiction','1818','Penguin Classics','English','9780141439471'),
    ('The Picture of Dorian Gray','Oscar Wilde','Gothic Fiction','1890','Penguin Classics','English','9780141439570'),
    ('A Nyomorultak','Victor Hugo','Classics','1862','Debreczeni','Hungarian','9789639517255'),
    ('The Hobbit','J.R.R. Tolkien','Fantasy','1937','Allen & Unwin','English','9780007458424'),
    ('Crime and Punishment','Fyodor Dostoevsky','Psychological Fiction','1866','Vintage Classics','English','9780099981909'),
    ('A kőszívű ember fiai (részlet)','Jókai Mór','Classics','1869','Nemzeti Tankönyvkiadó','Hungarian','9789631911264'),
    ('Little Women','Louisa May Alcott','Classics','1868','Penguin Classics','English','9780140390698'),
    ('A napló','Anne Frank','Biography','1947','Pocket Books','Hungarian','9789630753143'),
    ('One Hundred Years of Solitude','Gabriel García Márquez','Magical Realism','1967','Harper & Row','English','9780060883287'),
    ('A Háromtest-trilógia','Liu Cixin','Science Fiction','2008','Kairosz Kiadó','Hungarian','9789634520973'),
    ('Anna Karenina','Leo Tolstoy','Classics','1877','Penguin Classics','English','9780143035008'),
    ('Don Quixote','Miguel de Cervantes','Classics','1605','Vintage Classics','English','9780099469698'),
    ('The Adventures of Tom Sawyer','Mark Twain','Adventure','1876','Penguin Classics','English','9780140620698'),
    ('A nyárfa','István Örkény','Short Stories','1959','Szépirodalmi Könyvkiadó','Hungarian','9789631560498'),
    ('Great Expectations','Charles Dickens','Classics','1861','Penguin Classics','English','9780141439563'),
    ('Alice`s Adventures in Wonderland','Lewis Carroll','Fantasy','1865','Penguin Classics','English','9780141439761'),
    ('A testőr','Petrovics Emil','Fiction','1912','Franklin-Társulat','Hungarian','9789639864160'),
    ('The Brothers Karamazov','Fyodor Dostoevsky','Philosophical Fiction','1880','Penguin Classics','English','9780140449242'),
    ('Az ellopott napló','Irvin D. Yalom','Fiction','2007','Kalligram Kiadó','Hungarian','9789639636800'),
    ('Sense and Sensibility','Jane Austen','Romance','1811','Penguin Classics','English','9780141439662'),
    ('A nagy füzet','Szabó Magda','Fiction','1986','Magvető Könyvkiadó','Hungarian','9789631435646'),
    ('Wuthering Heights','Emily Brontë','Gothic Fiction','1847','Penguin Classics','English','9780141439556'),
    ('A vörös postakocsi','Jules Verne','Adventure','1876','Könyvmolyképző Kiadó','Hungarian','9786155207054'),
    ('The Road','Cormac McCarthy','Dystopian Fiction','2006','Vintage Books','English','9780307387899'),
    ('A Gyűrűk Ura','J.R.R. Tolkien','Fantasy','1954','Allen & Unwin','English','9780261103252'),
    ('A pál utcai fiúk (részlet)','Molnár Ferenc','Classics','1907','Nemzeti Tankönyvkiadó','Hungarian','9789631912254'),
    ('The Outsiders','S.E. Hinton','Young Adult Fiction','1967','Penguin Books','English','9780141189116'),
    ('A gyermekkor szobrai','Gyula Illyés','Memoir','1964','Magvető Könyvkiadó','Hungarian','9789631439013'),
    ('The Name of the Wind','Patrick Rothfuss','Fantasy','2007','DAW Books','English','9780756404741'),
    ('Az Ember Tragédiája','Imre Madách','Drama','1861','Magyar Elektronikus Könyvtár','Hungarian','9789635274167'),
    ('Slaughterhouse-Five','Kurt Vonnegut','Science Fiction','1969','Dell Publishing','English','9780385333849'),
    ('Az ördögűző','William Peter Blatty','Horror','1971','Harper & Row','Hungarian','9789639558364'),
    ('The Bell Jar','Sylvia Plath','Autobiographical Fiction','1963','Harper & Row','English','9780060837020'),
    ('A tüskevár','Molnár Ferenc','Young Adult Fiction','1923','Móra Könyvkiadó','Hungarian','9789631161160'),
    ('Catch-22','Joseph Heller','Satire','1961','Simon & Schuster','English','9781451626650'),
    ('A halál órája','Agatha Christie','Mystery','1937','Fekete Sas Kiadó','Hungarian','9789634292859'),
    ('The Hitchhiker`s Guide to the Galaxy','Douglas Adams','Science Fiction','1979','Pan Books','English','9780330508117'),
    ('Az Ezeregyéjszaka meséi','Anonymus','Folklore','1704','Corvina Kiadó','Hungarian','9789631339060'),
    ('Gone with the Wind','Margaret Mitchell','Historical Fiction','1936','Scribner','English','9781451635621'),
    ('A hattyú','Fekete István','Children`s Literature','1971','Móra Ferenc Könyvkiadó','Hungarian','9789631170155'),
    ('Dune','Frank Herbert','Science Fiction','1965','Ace Books','English','9780441172719'),
    ('Az ötödik pecsét','András Jeles','Drama','1976','Franklin-Társulat','Hungarian','9789630713984'),
    ('The Grapes of Wrath','John Steinbeck','Historical Fiction','1939','Penguin Books','English','9780143039433'),
    ('A sivatagi dervis','György Sebestyén','Adventure','1978','Europa Könyvkiadó','Hungarian','9789630709505'),
    ('The Count of Monte Cristo','Alexandre Dumas','Adventure','1844','Penguin Classics','English','9780140449266'),
    ('A Hamlet','William Shakespeare','Tragedy','1603','Nemzeti Tankönyvkiadó','Hungarian','9789631911097'),
    ('The Stand','Stephen King','Post-Apocalyptic Fiction','1978','Doubleday','English','9780307743688'),
    ('Az elveszett jelkép','Dan Brown','Thriller','2003','Gabo Kiadó','Hungarian','9789639978423'),
    ('The Secret History','Donna Tartt','Mystery','1992','Vintage Books','English','9781400031702'),
    ('Az ember tragédiája (részlet)','Imre Madách','Drama','1861','Szépirodalmi Könyvkiadó','Hungarian','9789630714509'),
    ('The Silmarillion','J.R.R. Tolkien','Fantasy','1977','Allen & Unwin','English','9780261102736'),
    ('Az angyali ének','Szabó Magda','Fiction','1985','Magvető Kiadó','Hungarian','9789631412385'),
    ('The Old Man and the Sea','Ernest Hemingway','Novella','1952','Scribner','English','9780684801223'),
    ('A hetedik pecsét','Ingmar Bergman','Drama','1957','Franklin-Társulat','Hungarian','9789630712529'),
    ('The Shining','Stephen King','Horror','1977','Doubleday','English','9780385121675'),
    ('A csodálatos mandarin','Bartók Béla','Libretto','1926','Bartók Records & Publishing','Hungarian','9789639155160'),
    ('The Martian','Andy Weir','Science Fiction','2011','Crown Publishing Group','English','9780553418026'),
    ('A gyűrűk ura (részlet)','J.R.R. Tolkien','Fantasy','1954','Nemzeti Tankönyvkiadó','Hungarian','9789631931460'),
    ('Jurassic Park','Michael Crichton','Science Fiction','1990','Ballantine Books','English','9780345538987'),
    ('A Király beszédének új fordítása','William Shakespeare','Drama','1608','Franklin-Társulat','Hungarian','9789630712871'),
    ('The Girl with the Dragon Tattoo','Stieg Larsson','Crime Fiction','2005','Norstedts förlag','English','9780307269751'),
    ('A titokzatos sziget','Jules Verne','Adventure','1875','Könyvmolyképző Kiadó','Hungarian','9786155042695'),
    ('The Da Vinci Code','Dan Brown','Thriller','2003','Doubleday','English','9780307474278'),
    ('A krónikák - Az idők kezdete','Margaret Weis, Tracy Hickman','Fantasy','1984','Bóbita Kiadó','Hungarian','9789639541250'),
    ('The Hunger Games','Suzanne Collins','Young Adult Fiction','2008','Scholastic Press','English','9780439023481'),
    ('Az Ember tragédiája (részlet)','Imre Madách','Drama','1861','Magyar Könyvklub','Hungarian','9789636623647'),
    ('The Catcher in the Rye','J.D. Salinger','Fiction','1951','Back Bay Books','English','9780316769488'),
    ('A Gyűrűk Ura: A gyűrű szövetsége','J.R.R. Tolkien','Fantasy','1954','Allen & Unwin','Hungarian','9789630736393'),
    ('1984','George Orwell','Dystopian Fiction','1949','Secker & Warburg','English','9780151660384'),
    ('A temetetlen halott','Nagy Lajos','Drama','1936','Európa Könyvkiadó','Hungarian','9789630798135'),
    ('The Girl on the Train','Paula Hawkins','Thriller','2015','Riverhead Books','English','9780735212169'),
    ('A légió visszatér','Sándor Kányádi','Poetry','1982','Helikon Kiadó','Hungarian','9789632074339'),
    ('The Time Traveler`s Wife','Audrey Niffenegger','Romance','2003','MacAdam/Cage','English','9780099464464'),
    ('A 7 próba','Agatha Christie','Mystery','1937','Fekete Sas Kiadó','Hungarian','9789634150104'),
    ('The Help','Kathryn Stockett','Historical Fiction','2009','Putnam Adult','English','9780399155345'),
    ('A Pál utcai fiúk - Részlet','Molnár Ferenc','Classics','1907','Franklin-Társulat','Hungarian','9789630712390'),
    ('The Night Circus','Erin Morgenstern','Fantasy','2011','Doubleday','English','9780385534642'),
    ('A megváltó','Sienkiewicz Henryk','Historical Fiction','1894','Alexandra Kiadó','Hungarian','9789634466217'),
    ('A tűzpróba','Suzanne Collins','Young Adult Fiction','2009','Scholastic Press','Hungarian','9789632549201'),
    ('A hattyú és a rózsa','Andersen','Children`s Literature','1838','Manó Könyvek','Hungarian','9789634481838'),
    ('The Thorn Birds','Colleen McCullough','Historical Fiction','1977','Harper & Row','English','9780060837556'),
    ('A szépség és a szörnyeteg','Jeanne-Marie Leprince de Beaumont','Children`s Literature','1756','Szépirodalmi Könyvkiadó','Hungarian','9789631562232'),
    ('The Lovely Bones','Alice Sebold','Fiction','2002','Little, Brown','English','9780316666343'),
    ('A kis hercegnő','Frances Hodgson Burnett','Children`s Literature','1905','Corvina Kiadó','Hungarian','9789631350256'),
    ('The Stand','Stephen King','Post-Apocalyptic Fiction','1978','Doubleday','English','9780345350688'),
    ('A Gatsby-metrom alatt','Fitzgerald Scott','Classics','1925','Franklin-Társulat','Hungarian','9789630710853'),
    ('The Thorn Birds','Colleen McCullough','Historical Fiction','1977','Harper & Row','English','9780062109395'),
    ('A bosszúálló','Edgar Allan Poe','Gothic Fiction','1841','Háttér Kiadó','Hungarian','9789639683964'),
    ('The Giver','Lois Lowry','Dystopian Fiction','1993','Houghton Mifflin','English','9780544340688'),
    ('A fáklya','Örkény István','Drama','1959','Magvető Kiadó','Hungarian','9789631422001'),
    ('The Nightingale','Kristin Hannah','Historical Fiction','2015','St. Martin`s Press','English','9780312577223'),
    ('A zsarnok keményebb','Gárdonyi Géza','Historical Fiction','1898','Alexandra Kiadó','Hungarian','9789634481913'),
    ('The Adventures of Huckleberry Finn','Mark Twain','Adventure','1884','Chatto & Windus','English','9781857150317'),
    ('A füveskönyv','Robert Graves','Nonfiction','1948','Palladis Rendelet','Hungarian','9789639478127'),
    ('The Goldfinch','Donna Tartt','Fiction','2013','Little, Brown','English','9780316055444'),
    ('A tűz megállítása','Sándor Petőfi','Poetry','1846','Kolibri Kiadó','Hungarian','9789639846364'),
    ('The Kite Runner','Khaled Hosseini','Historical Fiction','2003','Riverhead Books','English','9781594631931'),
    ('A kísértés próbája','Herman Melville','Adventure','1857','Európa Könyvkiadó','Hungarian','9789630773164'),
    ('The Alchemist','Paulo Coelho','Fiction','1988','HarperCollins','English','9780722532935'),
    ('A láthatatlan ember','Herbert George Wells','Science Fiction','1897','Nemzeti Tankönyvkiadó','Hungarian','9789631913206'),
    ('The Nightingale','Kristin Hannah','Historical Fiction','2015','St. Martin`s Press','English','9781447283051'),
    ('A tél királynője','Hans Christian Andersen','Fairy Tale','1844','Palladis Rendelet','Hungarian','9789639478011'),
    ('The Godfather','Mario Puzo','Crime Fiction','1969','G.P. Putnam`s Sons','English','9780451205766');