function MeetupCtrl($scope) {
  $scope.meetups = [{
    'title': 'Hacking with Vim',
    'description': 'Justin and Joel discuss one of the oldest and most powerful text editors available today - Vim. Discover the history, philosophy, and potential behind this amazing editor.',
    'slides': '',
    'date': {
      'month': 'Jan',
      'day': '16',
      'year': '2013',
      'time': '7-8pm'
    },
    'location': {
      'name': 'The Hash Tag',
      'mapURL': 'https://maps.google.com/maps?q=fresno+hashtag&ie=UTF-8&ei=6GD0UN7ZOOHf2QWDooHgDg&ved=0CAsQ_AUoAA'
    },
    'speakers': [{
      'name': 'Justin Gable',
      'url': 'https://github.com/justgable',
    }, {
      'name': 'Joel Holdbrooks',
      'url': 'https://github.com/noprompt',
    }]
  }]
}

var undefin = angular.module('undefin', ['ngResource']);

undefin.factory('Member', function($resource) {
  return $resource('/api/members.json', {}, {
    query: { method: 'GET', isArray: true},
  });
});

undefin.controller('MembersCtrl', function($scope, Member) {
  $scope.founders = []
  $scope.members = []

  Member.query(function(members) {
    $scope.founders = _.filter(members, function(member) {
      return member.founder
    })

    $scope.members = _.filter(members, function(member) {
      return !member.founder
    })
  })

  $scope.gravatarUrl = function(member, size) {
    var base = 'https://secure.gravatar.com/avatar/'
    var size = size ? size : 150
    return member.gravatar ? (base + member.gravatar + '?s=' + size) : ''
  }

  $scope.twitterUrl = function(member) {
    return member.twitter ? ('https://twitter.com/' + member.twitter) : '#'
  }

  $scope.githubUrl = function(member) {
    return member.github ? ('https://github.com/' + member.github) : '#'
  }

  $scope.dribbbleUrl = function(member) {
    return member.dribbble ? ('http://dribbble.com/' + member.dribbble) : '#'
  }
})
