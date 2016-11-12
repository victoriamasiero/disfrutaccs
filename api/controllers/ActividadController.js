

module.exports = {

	    registrar: function(req,res){

		Usuario.findOne(req.param('owner'), function encontraradmin (err, admin) {
        if(err) {return next(err);}
        
        res.view({ Usuario: admin });// ('/Local/mostrar/'+ Local.id);

     });
	},


    create: function(req,res,next){
    
        Local.create(req.params.all(), function Localcreado (err, Local) {
        if(err) {return next(err);}

        res.redirect ('/local/mostrar/'+ Local.id);
        

     });
    
    },

    mostrar: function(req,res,next){

    Local.findOne({id: req.param('id')}).exec(function(err,resultado){
    
    if (err) {return res.serverError(err);}


    Resena.find({idlocal:resultado.id}).exec(function(err,resultadoresena){

            if(resultadoresena === undefined){
            return res.view({Local:resultado}); }
            
            else{

                resultado.resenas = resultadoresena;
                res.view({Local:resultado});}
                });

              
         
        
     });
    }
	
};

