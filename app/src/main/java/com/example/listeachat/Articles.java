package com.example.listeachat;

public class Articles {
				private int _id;
				private String _nom;
				private String _magasin;
				private double _prix;
				private int _quantite;
				private String _imgUrl;

				public Articles(int _id, String _nom, String _magasin, double _prix, int _quantite, String _imgUrl) {
								this._id = _id;
								this._nom = _nom;
								this._magasin = _magasin;
								this._prix = _prix;
								this._quantite = _quantite;
								this._imgUrl = _imgUrl;
				}

				public Articles(String _nom, String _magasin, double _prix, int _quantite, String _imgUrl) {
								this._nom = _nom;
								this._magasin = _magasin;
								this._prix = _prix;
								this._quantite = _quantite;
								this._imgUrl = _imgUrl;
				}

				public int get_id() {
								return _id;
				}

				public void set_id(int _id) {
								this._id = _id;
				}

				public String get_nom() {
								return _nom;
				}

				public void set_nom(String _nom) {
								this._nom = _nom;
				}

				public String get_magasin() {
								return _magasin;
				}

				public void set_magasin(String _magasin) {
								this._magasin = _magasin;
				}

				public double get_prix() {
								return _prix;
				}

				public void set_prix(double _prix) {
								this._prix = _prix;
				}

				public int get_quantite() {
								return _quantite;
				}

				public void set_quantite(int _quantite) {
								this._quantite = _quantite;
				}

				public String get_imgUrl() {
								return _imgUrl;
				}

				public void set_imgUrl(String _imgUrl) {
								this._imgUrl = _imgUrl;
				}
}
