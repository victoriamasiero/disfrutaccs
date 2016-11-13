


module.exports = {
  connection: 'mysql',
  attributes: {
    Sexo: {
      type: 'string',
      size:10
    },
    Puntos: {
      type: 'float'
    },
    Codigo_postal: {
      type: 'float',
      size:20
    },
    Presupuesto: {
      type: 'float'
    },
    owner:{
      model:'Usuario'
    },
    clave: {
      type: 'string'
    }
  }
};

