DROP TABLE IF EXISTS utilisateur;

CREATE TABLE utilisateur (
                             id INT,
                             nom VARCHAR(255),
                             mot_de_passe VARCHAR(255),
                             email VARCHAR(255) UNIQUE,
                             nom_utilisateur VARCHAR(255) UNIQUE,
                             PRIMARY KEY (id)
);

DROP TABLE IF EXISTS adresse;

CREATE TABLE adresse (
                         id INT,
                         utilisateur_id INT,
                         est_active BOOLEAN,
                         pays VARCHAR(255),
                         ville VARCHAR(255),
                         nom_de_rue VARCHAR(255),
                         numero_de_voie_id INT,
                         complement VARCHAR(255),
                         PRIMARY KEY (id),
                         FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)
);

DROP TABLE IF EXISTS categorie;

CREATE TABLE categorie (
                           id INT,
                           nom VARCHAR(255) UNIQUE,
                           description VARCHAR(255),
                           PRIMARY KEY (id)
);

DROP TABLE IF EXISTS article;

CREATE TABLE article (
                         id INT,
                         vendeur_id INT,
                         nom VARCHAR(255),
                         note INT,
                         stock INT,
                         description VARCHAR(255),
                         prix DECIMAL(15,2),
                         photo VARCHAR(255),
                         PRIMARY KEY (id),
                         FOREIGN KEY (vendeur_id) REFERENCES utilisateur(id)
);

DROP TABLE IF EXISTS conversation;

CREATE TABLE conversation (
                              id INT,
                              objet VARCHAR(255),
                              date_conversation DATETIME,
                              utilisateur_1_id INT,
                              utilisateur_2_id INT,
                              PRIMARY KEY (id),
                              FOREIGN KEY (utilisateur_1_id) REFERENCES utilisateur(id),
                              FOREIGN KEY (utilisateur_2_id) REFERENCES utilisateur(id)
);

DROP TABLE IF EXISTS message;

CREATE TABLE message (
                         id INT,
                         date_message DATETIME,
                         message VARCHAR(255),
                         conversation_id INT,
                         redacteur_id INT,
                         PRIMARY KEY (id),
                         FOREIGN KEY (conversation_id) REFERENCES conversation(id),
                         FOREIGN KEY (redacteur_id) REFERENCES utilisateur(id)
);

DROP TABLE IF EXISTS panier;

CREATE TABLE panier (
                        article_id INT,
                        utilisateur_id INT,
                        quantite INT,
                        FOREIGN KEY (article_id) REFERENCES article(id),
                        FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)
);

DROP TABLE IF EXISTS commande;

CREATE TABLE commande (
                          id INT,
                          adresse_livraison_id INT,
                          adresse_facturation_id INT,
                          date_commande DATE,
                          utilisateur_id INT,
                          PRIMARY KEY (id),
                          FOREIGN KEY (adresse_livraison_id) REFERENCES adresse(id),
                          FOREIGN KEY (adresse_facturation_id) REFERENCES adresse(id),
                          FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)
);

DROP TABLE IF EXISTS commande_article;

CREATE TABLE commande_article (
                                  article_id INT,
                                  commande_id INT,
                                  quantite INT,
                                  FOREIGN KEY (article_id) REFERENCES article(id),
                                  FOREIGN KEY (commande_id) REFERENCES commande(id)
);