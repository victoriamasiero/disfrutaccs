
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

    buscar: function(req,res,next){

    Usuario.find({Alias:{'contains':req.param('Alias')} }).exec(function(err,resultado){
    
    if (err) {return res.serverError(err);}

    if(resultado !== undefined) {
    console.log(resultado);
    res.view({Usuario:resultado});
    }
    if(resultado === undefined){
    return res.notFound('Could not find, sorry.');}

     });    
    } ,

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
        },


    consultar: function(req,res){
     res.view();
    }

    editar: function(req,res,next){
    Usuario.findOne({id: req.param('id')}).exec(function(err,resultado){
    if (err) {return res.serverError(err);}
    
    if(resultado !== undefined) {
    res.view({Usuario:resultado});
    }
    if(resultado === undefined){
    return res.notFound('Errooor');}
        
     });
    },

    actualizar: function(req, res,next){

        Usuario.update(req.param('id'), req.params.all() , function Usuarioactualizado (err) {
        if(err) {return res.redirect('/Usuario/editar/'+req.param('id'));}

        res.redirect ('/Usuario/mostrar/'+ req.param('id'));
        
     });
    }


};

