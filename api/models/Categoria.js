/**
 * Categoria.js
 *
 * @description :: TODO: Categoria con su nombre (actualmente no en uso)
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
 connection: 'PostgresqlServer',
  attributes: {
    Nombre: {
      type: 'string',
      size:45,
      required: true
    }
  }
};

