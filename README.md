Custom-List-Me<p align="center"><img src="https://raw.githubusercontent.com/HephaisCode/HXAssets/master/Logos-64/idemobi.png" alt="idemobi" height="64"/><img src="https://raw.githubusercontent.com/HephaisCode/HXAssets/master/Logos-64/hephaiscode.png" alt="idemobi" height="64"/></p>

---

# Custom List Me App

#### Authors
![Licence Status](https://img.shields.io/badge/Author-Jean--François%20CONTART-purple.svg)
![Licence Status](https://img.shields.io/badge/Author-Jérôme%20DEMYTTENAERE-purple.svg)

#### Original Path 
[![Path](https://img.shields.io/badge/GitHub-Android--Custom--List--Me--App-ff4488.svg)](https://github.com/idemobi/Android-Custom-List-Me-App/)

#### Platform and Languages
![Platform Status](https://img.shields.io/badge/Platform-Android-lightgray.svg)
![Language Status](https://img.shields.io/badge/IDE-Android%20Studio-blue.svg)
![Language Status](https://img.shields.io/badge/Language-Java-blue.svg)

#### States of Projet
[![Build Status](https://travis-ci.org/idemobi/Android-Custom-List-Me-App.svg?branch=master)](https://travis-ci.org/idemobi/Android-Custom-List-Me-App)
[![Coverage Status](https://coveralls.io/repos/github/idemobi/Android-Custom-List-Me-App/badge.svg?branch=master)](https://coveralls.io/github/idemobi/Android-Custom-List-Me-App?branch=master)

#### Licence
![Licence Status](https://img.shields.io/badge/licence-Copyright-yellowgreen.svg)

---

# Instructions

## Création du projet :
- Dans Android Studio : File > New > New Project...
- Sur l'écran "Configure your new project" :
    - **Application name** : Nom de l'application (il sera aussi affiché sur le Téléphone).
    - **Compagny domain** : Identifiant de l'application (servira sur le compte Google Play Store, on met en général le nom de domain de l'éditeur, ex : idemobi.com).
    - **Project location** : Choisir un dossier sur votre ordinateur celui-ci servira a stocker le projet.
- Cliquer sur le bouton "Next"
- Sur l'écran "Select the form factors your app will run on" :
    - **Phone and Tablet** : Définir l'API min. (généralement on défini la valeur sur l'API 16, on pourra la modifier par la suite suivant les besoins).
- Cliquer sur le bouton "Next"
- Sur l'écran "Add an Activity to Mobile" :
    - Choisir **Empty Activity**
- Cliquer sur le bouton "Next"
- Sur l'écran "Customize the Activity" :
    - **Activity Name** : Modifier ou laisser le nom de l'activity (Class) choisie par default.
    - **Layout Name** : Modifier ou laisser le nom du layout (interface XML) choisie par default.
- Cliquer sur le bouton "Finish".

## Création de la ListView (XML) :
- A partir de l'onglet "Project" (situé sur la gauche d'Android studio)
- S'assurer que l'on soit bien en vue "Android" (Menu déroulant au dessus de l'arborescence du projet)
- Puis : app > res > layout : double click sur le fichier "activity_main.xml"
- S'assurer que l'on soit bien en vue "Text" (bouton situé en bas de l'écran)
- Remplacer le contenu avec :

```XML
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ListView
        android:id="@+id/listView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</RelativeLayout>
```

## Ajout du "ArrayAdapter" :
- Depuis : app > java > "com.domain.app" : double click sur le fichier "MainActivity"
- A l'intérieur de la méthode suivante ajouter l'adaptateur :

```Java
    private ListView _ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...

        _ListView = (ListView) findViewById(R.id.listView);

        List<People> tPeople = randomPeople();
        PeopleAdapter tAdapter = new PeopleAdapter(this, tPeople);
        _ListView.setAdapter(tAdapter);
    }
```
- Ajouter la méthode de génération de donnée :

```Java
    private List<People> randomPeople() {
        List<People> tPeople = new ArrayList<>();
        tPeople.add(new People(Color.BLACK, "Florent", "Mon premier message !"));
        tPeople.add(new People(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tPeople.add(new People(Color.GREEN, "Logan", "Que c'est beau..."));
        tPeople.add(new People(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tPeople.add(new People(Color.GRAY, "Willy", "On y est presque"));

        return tPeople;
    }
```

## Ajout de la classe "People" :

```Java
...
class People {
    private int color;
    private String pseudo;
    private String text;

    People(int color, String pseudo, String text) {
        this.color = color;
        this.pseudo = pseudo;
        this.text = text;
    }

    int getColor() {
        return color;
    }

    void setColor(int color) {
        this.color = color;
    }

    String getPseudo() {
        return pseudo;
    }

    void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }
}
```

> Omettre Private, Public ou Protected permet d'avoir un Package-private, une protection entre Private et Protected qui donne accés aux méthodes uniquement de la classe ou du package.


## Ajout de la classe Adapter "PeopleAdapter" :

```Java
...
class PeopleAdapter extends ArrayAdapter<People> {

    PeopleAdapter(Context context, List<People> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        RowViewHolder viewHolder = (RowViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new RowViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        People tName = getItem(position);
        viewHolder.pseudo.setText(tName.getPseudo());
        viewHolder.text.setText(tName.getText());
        viewHolder.avatar.setImageDrawable(new ColorDrawable(tName.getColor()));

        return convertView;
    }

    private class RowViewHolder {
        TextView pseudo;
        TextView text;
        ImageView avatar;
    }
}
```

# Travaux Dirigés

#TD n°1

- Lancer l'application sur un simulateur : Run > Run...
    - Cliquer sur le bouton "Create New Virtual Device"
    - Catégorie : **Phone**
    - Name : **Nexus 5X**
    - Cliquer sur le bouton "Next"
    - Sur l'écran "System Image" onglet "Recommended" Cliquer sur "Download"
    - Attender la fin de l'installation puis cliquer sur le bouton "Next"
    - Sur l'écran "Android Virtual Device (AVD)" :
        - **AVD Name** : Modifier ou laisser le nom défini pour l'émulateur.
        - **Startup orientation** : Choisir une orientation.
    - Cliquer sur le bouton "Finish".
    - Cliquer sur le lien  "Install Haxm" et suivre la procédure.
    
- Lancer l'application et constater l'affichage des prénoms dans une ListView

## TD n°2

- Ajouter un bouton pour recréer une liste à la volée
	- Ajouter une méthode de connexion au bouton
	- Ajouter une méthode de création d'une liste aléatoire
	
## TD n°3 depuis le TD n°2

- Ajouter un bouton pour ajouter une liste à la volée à la liste actuelle
	- Ajouter une méthode de connexion au bouton
	- Ajouter une méthode d'ajouter une liste aléatoire
	
## TD n°4 depuis le TD n°3

- Ajouter deux boutons pour trier la liste actuelle
	- Ajouter deux méthodes de connexion au bouton
	- Ajouter une méthode de tri alphabétique de la liste actuelle
	- Ajouter une méthode de tri colorimétrique de la liste actuelle

---

# To clone in your desktop with Terminal

![Terminal](https://raw.githubusercontent.com/HephaisCode/HXAssets/master/icons-64/terminal.png)

#### Checkout repository

- open "terminal.app" (OSX) or "cmd.exe" (WIN)
- clone repository
	
```Shell
cd <path of your git's repositories>
git clone https://github.com/idemobi/Android-Custom-List-Me-App
```
- clone submodule 

```
git submodule update --init --recursive
```


#### Switch to branch master

- open "Terminal.app" (OSX) or "cmd.exe" (WIN)

```Shell
cd <path of your git repositories>/Android-Custom-List-Me-App
git checkout --track origin/master
git checkout master
git branch
git submodule update --init --recursive
```
#### Switch to branch development

- open "Terminal.app" (OSX) or "cmd.exe" (WIN)

```Shell
cd <path of your git repositories>/Android-Custom-List-Me-App
git checkout --track origin/development
git checkout development
git branch
git submodule update --init --recursive
```

## To clone in your desktop with Git UI Application

![tower](https://raw.githubusercontent.com/HephaisCode/HXAssets/master/icons-64/tower.png)
![github desktop](https://raw.githubusercontent.com/HephaisCode/HXAssets/master/icons-64/github_desktop.png)
![sourcetree](https://raw.githubusercontent.com/HephaisCode/HXAssets/master/icons-64/sourcetree.png)

### Checkout repository

Just clone, check on the option for recursive dependencies checkout.

## Services
This repository use :
 - GitHub for source control : https://github.com
 - Héphaiscode for icon's pictures : https://github.com/HephaisCode/HXAssets/
 - shields.io for badges generation : http://shields.io
 - Travis for continous integration : https://travis-ci.org
 - Coveralls for code coverage : https://coveralls.io
 
 Special thanks for these services!

---

### Copyright 2017 
<p align="center"><img src="https://raw.githubusercontent.com/HephaisCode/HXAssets/master/Logos-64/idemobi.png" alt="idemobi" height="64"/><img src="https://raw.githubusercontent.com/HephaisCode/HXAssets/master/Logos-64/hephaiscode.png" alt="idemobi" height="64"/></p>