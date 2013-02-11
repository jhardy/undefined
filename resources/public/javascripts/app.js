// Utilities

var util = {
  twitterUrl: function(id) {
    return 'https://twitter.com/' + id
  },

  githubUrl: function(id) {
    return 'https://github.com/' + id
  },

  dribbbleUrl: function(id) {
    return 'http://dribbble.com/' + id
  }
}

// App

var undefin = angular.module('undefin', ['ngResource']);

undefin.factory('Member', function($resource) {
  return $resource('/api/members.json', {}, {
    query: { method: 'GET', isArray: true}
  })
})

undefin.factory('Meetup', function($resource) {
  return $resource('/api/meetups.json', {}, {
    query: { method: 'GET', isArray: true}
  })
})


// Members

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

// Meetups

undefin.controller('MeetupsCtrl', function($scope, Meetup) {
  $scope.meetups = []

  Meetup.query(function(meetups) {
    $scope.meetups = _.map(meetups, function(m) {
      var d = moment.utc(m.date)

      m.date = {
        month: d.format("MMM"),
        day: d.date(),
        year: d.year(),
        time: d.format("ha")
      }

      return m
    })
  })

  $scope.speakerUrl = function(speaker) {
    if (speaker.github) {
      return util.githubUrl(speaker.github)
    } else if (speaker.dribbble) {
      return util.dribbleUrl(speaker.github)
    } else if (speaker.twitter) {
      return util.twitterUrl(speaker.github)
    } else {
      return '#'
    }
  }

  $scope.meetupMonth = function(meetup) {
  }
})
