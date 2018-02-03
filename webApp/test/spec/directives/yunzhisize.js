'use strict';

describe('Directive: yunzhiSize', function () {

  // load the directive's module
  beforeEach(module('webAppApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<yunzhi-size></yunzhi-size>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the yunzhiSize directive');
  }));
});
