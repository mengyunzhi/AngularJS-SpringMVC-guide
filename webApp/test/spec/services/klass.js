'use strict';

describe('Service: klass', function () {

  // load the service's module
  beforeEach(module('webAppApp'));

  // instantiate service
  var klass;
  beforeEach(inject(function (_klass_) {
    klass = _klass_;
  }));

  it('should do something', function () {
    expect(!!klass).toBe(true);
  });

});
