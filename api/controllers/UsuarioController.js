
module.exports = {
	
	registrar: function(req,res){
		res.view();
	},

    create: function(req,res,next){

    Usuario.create(req.params.all(), function Usuariocreado (err, Usuario) {
        if(err) {return next(err);}  
          res.redirect ('/usuario/mostrar/'+ Usuario.id);

      });
    },


    mostrar: function(req,res,next){
    Usuario.findOne({id: req.param('id')}).exec(function(err,resultado){

    console.log(resultado)
    if (err) {return res.serverError(err);}
    console.log(resultado);
    res.view({Usuario:resultado});
        
     });
    },

    perfil: function (req,res,next){

    		Usuario.findOne({Alias:req.param('Alias')}).exec(function(err,resultado){
    		

    		if(resultado !== undefined ){
    			
    			if(resultado.clave === req.param('clave')){
    			return res.view({Usuario:resultado});}

    			else{return res.notFound('Clave invalida');}

    		}

    		res.redirect ('/usuario/perfil/?Alias='+req.param('Alias')+'&clave='+req.param('clave'));

    			}
    		)


    }
};
