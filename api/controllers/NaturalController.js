/**
 * NaturalController
 *
 * @description :: Server-side logic for managing Naturals
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {

	editar: function (req, res, next){

		Natural.findOne({idusuario:req.param('id')}).exec(function(err, resultado){
						if(resultado === undefined){
						var aux = req.params.all();
						res.view({datos: aux});

					 }

					else{
						res.redirect('/Natural/formulario/?idusuario='+req.param('id'));

					}
					});
	},

	crear: function(req,res,next){
		 
   		 Natural.create(req.params.all(), function Usuariocreado (err, info) {
        	if(err) {return next(err);}  
          Usuario.findOne({id:info.idusuario}).exec(function(err,resultado){

            res.redirect('/usuario/perfil?Alias='+resultado.Alias+'&Clave='+resultado.Clave);
          });
          

      });
    },


    formulario : function(req, res, next){

    	Natural.findOne({idusuario: req.param('idusuario')}).exec(function(err, respuesta){
    	res.view({datos: respuesta });


    	});


    },

    update: function(req, res,next){

    	
        Natural.update(req.param('idusuario'), req.params.all() , function preferenciaactualizada (err) {
        if(err) {return res.redirect('/');}
        Usuario.findOne({id:req.param('idusuario')}).exec(function(err,resultado){

            res.redirect('/usuario/perfil?Alias='+resultado.Alias+'&Clave='+resultado.Clave);
          });
     });
    }



	





	
};

