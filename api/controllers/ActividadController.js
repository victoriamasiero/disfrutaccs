

module.exports = {

	    registrar: function(req,res){

		Usuario.findOne(req.param('owner'), function encontraradmin (err, admin) {
        if(err) {return next(err);}
        
        res.view({Usuario:admin});// ('/Local/mostrar/'+ Local.id);

     });
	},

    create: function(req,res,next){
        
        Actividad.create(req.params.all(), function Actividadcreada (err, Actividad) {
        if(err) {return next(err);}

        res.redirect ('/actividad/mostrar/'+ Actividad.id);
        

     });
    
    },

    mostrar: function(req,res,next){

    Actividad.findOne({id: req.param('id')}).exec(function(err,resultado){
    
    if (err) {return res.serverError(err);}


    Resena.find({idlocal:resultado.id}).exec(function(err,resultadoresena){

            if(resultadoresena === undefined){
            return res.view({Actividad:resultado}); }
            
            else{

                resultado.resenas = resultadoresena;
                res.view({Actividad:resultado});}
                });

              
         
        
     });
    }
	
};

